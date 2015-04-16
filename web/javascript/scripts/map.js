var styles = {
    0: [new ol.style.Style({
            stroke: new ol.style.Stroke({
                color: '#cbcbcb',
                lineDash: [4],
                width: 3
            }),
            fill: new ol.style.Fill({
                color: 'rgba(255, 255, 255, 1)'
            })
        })],
    1: [new ol.style.Style({
            stroke: new ol.style.Stroke({
                color: 'red',
                lineDash: [4],
                width: 3
            }),
            fill: new ol.style.Fill({
                color: 'rgba(255, 0, 0, 0.6)'
            })
        })]
};

var styleFunction = function (feature, resolution) {
    return styles[feature.get("estado")];
};

var vectorUsg = new ol.layer.Vector({
    source: usgSource,
    //style: styleFunction
});

/*
var vectorParqueo = new ol.layer.Vector({
    source: parqueoSource,
    style: styleFunction
});
*/

/*
 [-8957754.689142367,-118388.66321236291],[-8957755.510243256,-118393.44052663073],[-8957758.570710208,-118392.84336234725],[-8957757.74960932,-118387.991402544],[-8957754.689142367,-118388.66321236291]
 [-8957757.74960932,-118387.991402544],[-8957758.645355744,-118392.76871681181],[-8957761.929759303,-118392.0969069929],[-8957760.959367342,-118387.24494718964],[-8957757.74960932,-118387.991402544]
*/

var map = new ol.Map({
    layers: [vectorUsg],
    target: 'map',
    view: new ol.View({
        center: [-8957872.927670488, -118438.04123405291],
        zoom: 19,
        minZoom: 17,
        maxZoom: 30
    })
});

zoomslider = new ol.control.ZoomSlider();
map.addControl(zoomslider);