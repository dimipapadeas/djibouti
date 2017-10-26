function makeplot() {

    //  Dorra
    Plotly.d3.csv(dorra, function (data) { processData(data, 'date', 'temperature', 'bar', 'dorraTemp') });
    Plotly.d3.csv(dorra, function (data) { processData(data, 'date', 'wind', 'scatter', 'dorraWind') });
    Plotly.d3.csv(dorra, function (data) { processData(data, 'date', 'rain', 'box', 'dorraRain') });
    Plotly.d3.csv(dorra, function (data) { processData(data, 'date', 'humidity', 'histogram2dcontour', 'dorraHumd') });

    // Lac Assal 
    Plotly.d3.csv(lacAssal, function (data) { processData(data, 'date', 'temperature', 'scattergl', 'lacAssalTemp') });
    Plotly.d3.csv(lacAssal, function (data) { processData(data, 'date', 'wind', 'bar', 'lacAssalWind') });
    Plotly.d3.csv(lacAssal, function (data) { processData(data, 'date', 'rain', 'scattergl', 'lacAssalRain') });
    Plotly.d3.csv(lacAssal, function (data) { processData(data, 'date', 'humidity', 'scatter', 'lacAssalHumd') });


    // read two or more csvs
    Plotly.d3.csv(dorra, function (csvData1) {
        Plotly.d3.csv(lacAssal, function (csvData2) {
            /* merge csvData1 and csvData2 into plotly 'data' and 'layout' */
            prepareCompareData(csvData1, csvData2, 'date', 'temperature', 'TBD', 'cmpDiv');
        });
    });

};
// Arguments:
var dorra = "/csvs/Dorra.csv";
var lacAssal = "/csvs/LacAssal.csv";


function processData(allRows, axisXData, axisYData, plotType, divName) {

    this.plotType = plotType;
    this.divName = divName;
    console.log(allRows);
    //add check of allRows
    var x = [], y = [], standard_deviation = [];

    for (var i = 0; i < allRows.length; i++) {
        row = allRows[i];
        x.push(row[axisXData]);
        y.push(row[axisYData]);
    }
    makePlotly(x, y, standard_deviation, axisXData, axisYData, plotType, divName);

}

function makePlotly(x, y, standard_deviation, axisXData, axisYData, plotType, divName) {

    var plotDiv = document.getElementById("plot");
    var traces = [{
        x: x,
        y: y,
        mode: 'lines',
        type: plotType,
    }];

    axisXData = capitalize(axisXData);
    axisYData = capitalize(axisYData);
    var layout = {
        title: 'Weather data sample',
        xaxis: {
            title: axisXData,
            showgrid: false,
            zeroline: false
        },
        yaxis: {
            title: axisYData,
            showline: false
        }
    };

    Plotly.newPlot(divName, traces, layout, { displayModeBar: false });
};



function prepareCompareData(allRows1, allRows2, axisXData, axisYData, plotType, divName) {

    var x = [], y = [], x1 = [], y1 = [];

    for (var i = 0; i < allRows1.length; i++) {
        row = allRows1[i];
        x.push(row[axisXData]);
        y.push(row[axisYData]);
    }


    for (var i = 0; i < allRows2.length; i++) {
        row = allRows2[i];
        x1.push(row[axisXData]);
        y1.push(row[axisYData]);
    }
    makepCompareplot(x, y, x1, y1, axisXData, axisYData, plotType, divName);

}

function makepCompareplot(x1, y1, x2, y2, axisXData, axisYData, plotType, divName) {

    var trace1 = {
        x: x1,
        y: y1,
        name: 'Dorra',
        fill: 'tozeroy',
        type: 'linear'
    };
    var trace2 = {
        x: x2,
        y: y2,
        name: 'Lac Assal',
        fill: 'tonexty',
        type: 'linear',
    };
    var data = [trace1, trace2];

    axisXData = capitalize(axisXData);
    axisYData = capitalize(axisYData);
    var layout = {
        title: 'Compare',
        xaxis: {
            title: axisXData,
            showgrid: false,
            zeroline: false
        },
        yaxis: {
            title: axisYData + "(°C)",
            titlefont: {
                family: 'Courier New, monospace',
                size: 18,
                color: '#7f7f7f'
            },
            showline: false,

        }
    };

    Plotly.newPlot('cmpDiv', data, layout, { displayModeBar: false });


}


function capitalize(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}


makeplot();







