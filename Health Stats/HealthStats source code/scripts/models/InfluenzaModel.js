class InfluenzaDataModel {
	constructor(season, virus, AgeGroupModel) {
		this.season = season;
		this.virus = virus;
		this.AgeGroupModel = AgeGroupModel;
	}

	getSeason() {
		return this.season;
	}

	getVirus() {
		return this.virus;
	}

	getAgeGroupModel() {
		return this.AgeGroupModel;
	}
}