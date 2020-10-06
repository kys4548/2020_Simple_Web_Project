const path = require("path");

module.exports = {
  name: "word-relay-setting", // name을 불필요
  mode: "development", // 실 서비스: production
  devtool: "eval", // 빠르게
  resolve: {
    extensions: [".js", ".jsx"],
  },

  //여기서부터 중요!!
  entry: {
    app: ["./client"],
  }, // 입력

  module: {
    rules: [
      {
        test: /\.jsx?$/, //js와 jsx파일에 rule를 적용하겠다.
        loader: "babel-loader", // js, jsx파일에 바벨을 적용해 최신이나
        //실험적인 문법을 옛날 호환되는 문법으로 바꿔주겠다.
        options: {
          plugins: ["@babel/plugin-proposal-class-properties"],
          presets: ["@babel/preset-env", "@babel/preset-react"],
        },
      },
    ],
  },

  output: {
    path: path.join(__dirname, "dist"), // 현재경로/dist
    filename: "app.js",
  }, //출력
};
