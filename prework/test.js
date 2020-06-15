function alphaBeta() {
	var ans = “”;
	for(i=1;i<101;i++){
		if(i%3==0){
			ans += “Alpha”;
		}
		if(i%5==0){
			ans += “Beta”;
		}
		Else{
			ans = i;
		}
	console.log(ans);
	}
}

alphaBeta()
