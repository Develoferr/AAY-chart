package com.aay.compose.lineChart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aay.compose.lineChart.model.BackGroundGrid
import com.aay.compose.lineChart.model.LineParameters

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    linesParameters: List<LineParameters> = LineChartDefault.lineParameters,
    backGroundColor: Color = LineChartDefault.backGroundColor,
    xAxisData: List<String> = LineChartDefault.xAxisData,
    showBackgroundGrid: BackGroundGrid = LineChartDefault.backGroundGrid,
    barWidthPx: Dp = LineChartDefault.backgroundLineWidth,
    animateChart: Boolean = LineChartDefault.ANIMATED_CHART,
    pathEffect: PathEffect = LineChartDefault.pathEffect,
    descriptionStyle: TextStyle = LineChartDefault.descriptionDefaultStyle,
    yAxisStyle: TextStyle = LineChartDefault.axesStyle,
    xAxisStyle: TextStyle = LineChartDefault.axesStyle
) {

    Box(modifier = Modifier.wrapContentHeight()) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            ChartDescription(
                chartLineDetails = linesParameters,
                descriptionStyle = descriptionStyle,
            )
            ChartContent(
                modifier = modifier.aspectRatio(3 / 2f).background(Color.Green.copy(.5f)),
                linesParameters = linesParameters,
                backGroundColor = backGroundColor,
                xAxisData = xAxisData,
                showBackgroundGrid = showBackgroundGrid,
                barWidthPx = barWidthPx,
                animateChart = animateChart,
                pathEffect = pathEffect,
                yAxisStyle = yAxisStyle,
                xAxisStyle = xAxisStyle
            )
        }
    }
}