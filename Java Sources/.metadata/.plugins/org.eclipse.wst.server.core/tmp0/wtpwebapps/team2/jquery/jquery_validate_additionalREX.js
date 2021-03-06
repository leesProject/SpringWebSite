

$.validator.addMethod("idRex", function(value, element) {
	return this.optional(element) || /^[A-Za-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{4,20}$/.test(value);
}); 

$.validator.addMethod("pwRex", function(value, element) {
	return this.optional(element) || /^[A-Za-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣!@#$%^&]{6,20}$/.test(value);
}); 

$.validator.addMethod("nameRex", function(value, element) {
	return this.optional(element) || /^[A-Za-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{2,20}$/.test(value);
});

$.validator.addMethod("emailRex", function(value, element) {
	return this.optional(element) || /^[0-9a-zA-Z][_0-9a-zA-Z-]*@[\.0-9a-zA-Z-]{6,30}$/.test(value);
});

$.validator.addMethod("phoneRex", function(value, element) {
	return this.optional(element) || /^[0-9]{6,20}$/.test(value);
}); 


