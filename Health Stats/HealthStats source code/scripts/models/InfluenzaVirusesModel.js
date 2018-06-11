class InfluenzaVirusesModel {
	constructor(records) {
		this._records = records;
		this.groupByVirusEventDispatcher = new EventDispatcher(this);
	}

	addRecord(record) {
		this.viruses.push(record);
	}

	groupByVirus() {
  		const recordByField = new Map();
  		const map = new Map();
  		this._records.forEach((influenzaData) => {
        	const key = influenzaData.getVirus();
        	let value = null;
	        if (!map.has(key)) {
	            value = influenzaData.getAgeGroupModel().getCountOfAgeGroupModels();
	        } else {
	        	value = map.get(key) + influenzaData.getAgeGroupModel().getCountOfAgeGroupModels();
	        }
	        map.set(key, value);
    	});
  		this.groupByVirusEventDispatcher.notify(map);
    }

    getRecords() {
    	return this._records;
    }
}