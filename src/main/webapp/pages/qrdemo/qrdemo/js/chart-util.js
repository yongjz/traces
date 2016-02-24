var sample = sample || {};
sample.chartUtil = sample.chartUtil || {};

sample.chartUtil.drawRing = function(targetD3Selecotr, innerRadius,
		outerRadius, dataSet, colorSet) {
	var pie = d3.layout.pie(dataSet);

	var arc = d3.svg.arc().outerRadius(outerRadius).innerRadius(innerRadius);

	var svg = d3.select(targetD3Selecotr).append("svg").attr("width",
			outerRadius * 2).attr("height", outerRadius * 2);

	var colors = colorSet || d3.scale.category10();
	var arcs = svg.selectAll("g.arc").data(pie(dataSet)).enter().append("g")
			.attr("class", "arc").attr("transform",
					"translate(" + outerRadius + "," + outerRadius + ")");
	arcs.append("path").attr("fill", function(d, i) {
		return colors[i];
	}).attr("d", arc);
	arcs.append("text").attr("transform", function(d) {
		return "translate(" + arc.centroid(d) + ")";
	}).attr("text-anchor", "middle");
};