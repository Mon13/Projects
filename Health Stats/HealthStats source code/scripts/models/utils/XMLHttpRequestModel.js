class XMLHttpRequestModel {
	constructor(method, url) {
		this._method = method;
		this._url = url;
		
		this.readComplete = new EventDispatcher(this);
	}

	seturl(url) {
		this._url = url;
	}

	setMethod(method) {
		this._method = method;
	}

	getData() {
		let xhr = new XMLHttpRequest();
		xhr.open(this._method, this._url, true);
		let _this = this;

		xhr.onreadystatechange = function () {
	        if(xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
	            _this.readComplete.notify(xhr.responseText);
	        }
   		};
		xhr.send();
	}
}