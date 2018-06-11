class CSVParserFactory {
	static getInstance(type) {
		let CSVParser = CSV_PARSER_TYPE[type];
		let parser = null;

		if(CSVParser) {
			parser = new CSVParser();
		}
		return parser;
	}
}	