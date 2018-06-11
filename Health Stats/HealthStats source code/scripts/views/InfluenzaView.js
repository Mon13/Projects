class InfluenzaView {

    constructor(model, elements) {
        this._model = model;
        this._elements = elements;

        this.groupByButtonClicked = new EventDispatcher(this);

        var _this = this;

        //attach model events
        this._model.groupByVirusEventDispatcher.attach(function(sender, data) {
            console.log(data)
        })

        // attach listeners to HTML controls
        this._elements.groupByButton.addEventListener("click", function () {
            _this.groupByButtonClicked.notify();
        });
    }

    builGraph() {
        
    }
}
