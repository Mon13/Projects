class AgeGroupModel {
	setZeroToFour(value) {
		this._zeroToFour = value;
	}

	setFiveToTwentyFour(value) {
		this._fiveToTwentyFour = value;
	}

	setTwentyFiveToSixtyFour(value) {
		this._twentyFiveToSixtyFour = value;
	}

	setSixtyFivePlus(value) {
		this._sixtyFivePlus = value;
	}
	
	getZeroToFour() {
		return this._zeroToFour;
	}

	getFiveToTwentyFour() {
		return this._fiveToTwentyFour;
	}

	getTwentyFiveToSixtyFour() {
		return this._twentyFiveToSixtyFour;
	}

	getSixtyFivePlus() {
		return this._sixtyFivePlus;
	}

	getCountOfAgeGroupModels(){
		return this.getZeroToFour() + this.getFiveToTwentyFour() + this.getTwentyFiveToSixtyFour() + this.getSixtyFivePlus();
	}
}