package com.aay.compose.lineChart

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aay.compose.lineChart.model.LineParameters

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    linesParameters: List<LineParameters> = LineChartDefault.lineParameters,
    gridColor: Color = LineChartDefault.gridColor,
    xAxisData: List<String> = emptyList(),
    isShowGrid: Boolean = LineChartDefault.IS_SHOW_GRID,
    barWidthPx: Dp = LineChartDefault.backgroundLineWidth,
    animateChart: Boolean = LineChartDefault.ANIMATED_CHART,
    showGridWithSpacer: Boolean = LineChartDefault.SHOW_BACKGROUND_WITH_SPACER,
    descriptionStyle: TextStyle = LineChartDefault.descriptionDefaultStyle,
    yAxisStyle: TextStyle = LineChartDefault.axesStyle,
    xAxisStyle: TextStyle = LineChartDefault.axesStyle,
    chartRatio: Float = LineChartDefault.chartRatio
) {

    Box(modifier.wrapContentHeight()) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            ChartDescription(
                chartLineDetails = linesParameters,
                descriptionStyle = descriptionStyle,
            )

            ChartContent(
                modifier = if (chartRatio == 0f) Modifier.wrapContentSize()
                else Modifier.aspectRatio(chartRatio)
                    .fillMaxSize(),
                linesParameters = linesParameters,
                gridColor = gridColor,
                xAxisData = xAxisData,
                isShowGrid = isShowGrid,
                barWidthPx = barWidthPx,
                animateChart = animateChart,
                showGridWithSpacer = showGridWithSpacer,
                yAxisStyle = yAxisStyle,
                xAxisStyle = xAxisStyle
            )
        }
    }
}