function require(path) {
	let jsPath = getScriptsPath().concat(path);
    document.write('<script type="text/javascript" src="'+jsPath+'"><\/script>');
}

function getScriptsPath() {
	return getRootWebSitePath().concat("/scripts");
}

function getRootWebSitePath() {
    var _location = document.location.toString();
    var applicationNameIndex = _location.indexOf('/', _location.indexOf('://') + 3);
    var applicationName = _location.substring(0, applicationNameIndex) + '/';
    var webFolderIndex = _location.indexOf('/', _location.indexOf(applicationName) + applicationName.length);
    var webFolderFullPath = _location.substring(0, webFolderIndex);

    return webFolderFullPath;
}

// import controllers
require("/controllers/InfluenzaController.js");

//import models
require("/models/InfluenzaVirusesModel.js");
require("/models/InfluenzaModel.js");
require("/models/EventDispatcher.js");
require("/models/AgeGroupModel.js");
require("/models/utils/CSVParser.js");
require("/models/utils/InfluenzaDataCSVParser.js");
require("/models/utils/CSVParserType.js");
require("/models/utils/CSVParserFactory.js");
require("/models/utils/XMLHttpRequestModel.js");

//import views
require("/views/InfluenzaView.js");