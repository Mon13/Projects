class InfluenzaController {

    constructor(model, view) {
        this._model = model;
        this._view = view;

        var _this = this;

        this._view.groupByButtonClicked.attach(function () {
            _this.groupByVirus();
        });
    }

    groupByVirus() {
         var item = window.prompt('Add item:', '');
         if (item) {
            this._model.groupByVirus();
        }
    }
}