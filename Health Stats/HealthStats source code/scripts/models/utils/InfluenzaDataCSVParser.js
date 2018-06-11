class InfluenzaDataCSVParser extends CSVParser {
	getRawData(xhr, callback) {
  		xhr.readComplete.attach(function(sender, data) {
  			callback(sender, data);
  		});
  		xhr.getData()
	}

	readLines(xhr, callback) {
		this.getRawData(xhr, function(sender, data) {
			let lines = data.split("\n");
			callback(sender, lines);
		});
	}

	parseLines(xhr, callback) {
		
		this.getRawData(xhr, function(sender, rawData) {
			let rawLines = rawData.split("\n");
			let data = [];

			rawLines.forEach(function(rawLine) {
				let parts = rawLine.split(",");
	
				let season = parts[0];
				let virus = parts[1];

				let ageGroup = new AgeGroupModel();
				ageGroup.setZeroToFour(parts[2]);
				ageGroup.setFiveToTwentyFour(parts[3]);
				ageGroup.setTwentyFiveToSixtyFour(parts[4]);
				ageGroup.setSixtyFivePlus(parts[5]);
					

				var influenzaData = new InfluenzaDataModel(season, virus, ageGroup);

				data.push(influenzaData);
			});
			
			callback(data)
		});
	}	
}