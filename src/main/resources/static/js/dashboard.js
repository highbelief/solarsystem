document.addEventListener("DOMContentLoaded", function() {
    fetchData();

    async function fetchData() {
        try {
            const chartDataResponse = await fetch('http://localhost:8081/api/data/chart');
            if (chartDataResponse.ok) {
                const chartData = await chartDataResponse.json();
                renderChart(chartData);
            } else {
                console.error("그래프 데이터를 불러오는 데 실패했습니다.");
            }

            const predictionResponse = await fetch('http://localhost:8081/api/predictions/tomorrow');
            if (predictionResponse.ok) {
                const predictionData = await predictionResponse.json();
                console.log("Prediction Data:", predictionData);  // 응답 데이터 확인

                const predictedPower = predictionData.predictedPower || {};
                const predictedBattery = predictionData.predictedBattery || {};

                document.getElementById('predictedPower').innerHTML =
                    Object.entries(predictedPower).length > 0 ?
                        Object.entries(predictedPower).map(
                            ([time, power]) => `<p>${time}: ${power} kW</p>`
                        ).join('') : "<p>예측 발전량 데이터가 없습니다.</p>";

                document.getElementById('predictedBattery').innerHTML =
                    Object.entries(predictedBattery).length > 0 ?
                        Object.entries(predictedBattery).map(
                            ([time, battery]) => `<p>${time}: ${battery} %</p>`
                        ).join('') : "<p>예측 배터리 데이터가 없습니다.</p>";
            } else {
                console.error("내일 예측 데이터를 불러오는 데 실패했습니다.");
            }
        } catch (error) {
            console.error("에러:", error);
        }
    }

    function renderChart(data) {
        console.log("Chart Data:", data);  // 데이터 확인
        const ctx = document.getElementById('powerChart').getContext('2d');
        new Chart(ctx, {
            type: 'line',
            data: {
                labels: data.timestamps,
                datasets: [
                    {
                        label: '발전량 (kW)',
                        data: data.powerGenerated,
                        borderColor: 'rgba(75, 192, 192, 1)',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        fill: true,
                    },
                    {
                        label: '배터리 충전량 (%)',
                        data: data.batteryLevel,
                        borderColor: 'rgba(255, 99, 132, 1)',
                        backgroundColor: 'rgba(255, 99, 132, 0.2)',
                        fill: true,
                    }
                ]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: '오늘의 발전량 및 배터리 상태'
                    }
                },
                scales: {
                    x: {
                        display: true,
                        title: {
                            display: true,
                            text: '시간'
                        }
                    },
                    y: {
                        display: true,
                        title: {
                            display: true,
                            text: '수치'
                        },
                        beginAtZero: true
                    }
                }
            }
        });
    }
});
