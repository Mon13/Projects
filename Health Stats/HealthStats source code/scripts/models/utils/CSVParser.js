class CSVParser {
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
		this.getRawData(xhr, function(sender, data) {
			let rawLines = data.split("\n");
			let lines = [];
			rawLines.forEach(function(rawLine) {
				let parts = rawLine.split(",");
				let line = [];
				parts.forEach(function(part){
					line.push(part);
				});
				lines.push(line);
			})
			callback(lines);
		});
	}	
}	