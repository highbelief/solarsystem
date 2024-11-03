document.addEventListener("DOMContentLoaded", function() {
    fetchLogs();

    async function fetchLogs() {
        try {
            const logDataResponse = await fetch('/api/logs');
            if (logDataResponse.ok) {
                const logs = await logDataResponse.json();
                console.log(logs);  // 응답 데이터를 콘솔에 출력하여 확인
                const logDataElement = document.getElementById('logData');
                logDataElement.innerHTML = logs.map(log =>
                    `<li class="list-group-item">[${log.timestamp}] ${log.message}</li>`
                ).join('');
            } else {
                console.error("로그 데이터를 불러오는 데 실패했습니다.");
            }
        } catch (error) {
            console.error("에러:", error);
        }
    }
});