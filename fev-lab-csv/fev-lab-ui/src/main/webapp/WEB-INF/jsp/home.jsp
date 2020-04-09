<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Bootstrap 4 Example</title>
    <script
      type="text/javascript"
      src="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.15.0/js/jquery.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.15.0/js/popper.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.15.0/js/bootstrap.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://mdbootstrap.com/api/snippets/static/download/MDB-Pro_4.15.0/js/mdb.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://mdbootstrap.com/wp-content/themes/mdbootstrap4/js/plugins/mdb-plugins-gathered.min.js"
    ></script>
  </head>

  <body>
    <div id="flexBody" style="display: flex;">
      <table>
        <tr>
          <td><button id="deleteRecords">Delete all records</button></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td><button id="req">Get available files</button></td>
          <td><span id="reqSpan"></span></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td>Count</td>
          <td></td>
        </tr>
        <tr>
          <td><button id="saveFileReq">Save File</button></td>
          <td><input id="fileName" type="text" value="example_small.cs"/></td>
        </tr>
        <tr>
          <td></td>
          <td>Count</td>
          <td>Filter by metrics</td>
          <td>Default filters are 'headers=ActMod_trq.MCD.UserAvg&headers=BattU_u.MCD.UserAvg&headers=CEngDsT_t.MCD.UserAvg'</td>
        </tr>
        <tr>
          <td><button id="makeFileReq">Get records</button></td>
          <td><input id="count" type="text" value="18"/></td>
          <td><input id="headers" type="text" value="headers=ActMod_trq.MCD.UserAvg&headers=BattU_u.MCD.UserAvg&headers=CEngDsT_t.MCD.UserAvg"/></td>
        </tr>
      </table>
    </div>

    <script type="text/javascript">

      document.getElementById('deleteRecords').addEventListener('click', (ev) => {
        fetch(
          "http://localhost:8080/records/delete",
          {method: 'DELETE'}
        ).then((response) => response.json());
      });

      document.getElementById('req').addEventListener('click', (ev) => {
        fetch('http://localhost:8080/files')
          .then((response) => response.json())
          .then((response) => {
            response.files.forEach((file) => {
              const elem = document.createElement('span');
              elem.innerHTML = file.name + ", ";

              document.getElementById('reqSpan').append(elem);
            });
          });
      });

      document.getElementById('saveFileReq').addEventListener('click', (ev) => {
        const param = document.getElementById('fileName').value;

        fetch(
          "http://localhost:8080/files/save?file=" + param,
          {mode: 'no-cors', method: 'POST'}
        ).then((response) => response.json());
      });

      document.getElementById('makeFileReq').addEventListener('click', (ev) => {
        const param = document.getElementById('count').value;
        const param2 = document.getElementById('headers').value;

        fetch("http://localhost:8080/records/numeric?count=" + param + "&" + param2)
          .then((response) => response.json())
          .then((response) => {
                var canvasElem = document.getElementsByTagName("canvas"), index;

                      for (index = canvasElem.length - 1; index >= 0; index--) {
                          canvasElem[index].parentNode.removeChild(canvasElem[index]);
                      }
            const firstLevel = response.records;
            const data = firstLevel.reduce(
              (firstLevelAcc, firstLevelRecord) => {
                return firstLevelRecord.records.reduce(
                  (secondLevelAcc, secondLevelRecord) => {
                    if (!firstLevelAcc[secondLevelRecord.name]) {
                      firstLevelAcc[secondLevelRecord.name] = {
                        label: secondLevelRecord.name,
                        data: [],
                        fill: false,
                        backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(255, 159, 64, 0.2)',
                          'rgba(255, 205, 86, 0.2)',
                          'rgba(75, 192, 192, 0.2)',
                          'rgba(54, 162, 235, 0.2)',
                          'rgba(153, 102, 255, 0.2)',
                          'rgba(201, 203, 207, 0.2)',
                        ],
                        borderColor: [
                          'rgb(255, 99, 132)',
                          'rgb(255, 159, 64)',
                          'rgb(255, 205, 86)',
                          'rgb(75, 192, 192)',
                          'rgb(54, 162, 235)',
                          'rgb(153, 102, 255)',
                          'rgb(201, 203, 207)',
                        ],
                        borderWidth: 1,
                      };
                    }

                    firstLevelAcc[secondLevelRecord.name].data.push(
                      secondLevelRecord.value
                    );

                    return firstLevelAcc;
                  },
                  {}
                );
              },
              {}
            );

            Object.values(data).forEach((value) => {
              const element = document.createElement('canvas');
              element.setAttribute("height", "50");
              document.body.append(element);

              const labels = new Array(value.data.length);

              for (var i = 0; i < labels.length; i++) {
                labels[i] = i;
              }

              new Chart(element, {
                type: 'horizontalBar',
                data: {
                  labels: labels,
                  datasets: [value],
                },
                options: {
                  scales: {
                    xAxes: [
                      {
                        ticks: {
                          beginAtZero: true,
                        },
                      },
                    ],
                  },
                },
              });
            });
          });
      });
    </script>
  </body>
</html>

