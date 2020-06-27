function outter() {
	var title = "closer test";
  
  return function() {
  	document.write(title);
  }
}


inner = outter();
inner();


function factory_movie(title) {
	return {
  	set_title : function(_title) {
    	title = _title;
    },
    get_title : function() {
    	return title;
    }
  }
}



movie1 = factory_movie("matrix");
document.write(movie1.get_title());

movie2 = factory_movie("ghost");
document.write(movie2.get_title());
document.write(movie1.get_title());