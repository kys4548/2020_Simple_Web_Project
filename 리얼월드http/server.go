package main

import (
	"fmt"
	"log"
	"net/http"
	"net/http/httputil"
)

//가장 기본 http 통신
func handler1(w http.ResponseWriter, r *http.Request) {
	dump, err := httputil.DumpRequest(r, true)
	if err != nil {
		http.Error(w, fmt.Sprint(err), http.StatusInternalServerError)
		return
	}
	fmt.Println(string(dump))
	fmt.Fprintf(w, "hello")
}

//쿠키를 설정한 http 통신
func handler2(w http.ResponseWriter, r *http.Request) {
	dump, err := httputil.DumpRequest(r, true)
	if err != nil {
		http.Error(w, fmt.Sprint(err), http.StatusInternalServerError)
		return
	}
	fmt.Println(string(dump))
	//쿠키 설정
	w.Header().Add("Set-Cookie", "max-age=5; visit=true; sid=486")

	if _, ok := r.Header["Cookie"]; ok {
		fmt.Fprintf(w, "두번 이상 방문")
	} else {
		fmt.Fprintf(w, "첫 방문")
	}
}

//인증을 사용한 http통신
func handlerDigest(w http.ResponseWriter, r *http.Request) {
	// pp.Printf("URL: %s\n", r.URL.String())
	// pp.Printf("Query: %v\n", r.URL.Query())
	// pp.Printf("Proto: %s\n", r.Proto)
	// pp.Printf("Method: %s\n", r.Method)
	// pp.Printf("Header: %s\n", r.Header)
	// defer r.Body.Close()
	dump, err := httputil.DumpRequest(r, true)
	if err != nil {
		http.Error(w, fmt.Sprint(err), http.StatusInternalServerError)
		return
	}
	fmt.Println(string(dump))
	//body, _ := ioutil.ReadAll(r.Body)
	//fmt.Printf("--body--\n%s\n", string(body))
	if _, ok := r.Header["Authorization"]; !ok {
		w.Header().Add("WWW-Authenticate", `Digest realm="Secrect Zone",
						nonce="1234567890",
						argorithm=MD5, qop="auth"`)
		w.WriteHeader(http.StatusUnauthorized)
		fmt.Fprintf(w, "fail???")
	} else {
		fmt.Fprintf(w, "secret page\n")
	}
}
func main() {
	var httpServer http.Server
	http.HandleFunc("/", handler2)
	//http.HandleFunc("/digest", handlerDigest)
	log.Println("start http listening :18888")
	httpServer.Addr = ":18888"
	log.Println(httpServer.ListenAndServe())
}
