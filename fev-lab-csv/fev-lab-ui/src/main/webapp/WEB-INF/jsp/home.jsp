<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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
    <canvas id="horizontalBar"></canvas>
    <script type="text/javascript">

        // TODO когда будет запрос на эндпоинт нужно расскоментировать эту строку и удалить переменную response
      //   fetch('./response_1586461027419.json').then((response) => {

      const response = {
        records: [
          {
            records: [
              {
                name: 'FRQ_REC',
                measure: 'Hz',
                value: '100.000000000000000000',
                numeric: true,
              },
              {
                name: 'NRO_REC',
                value: '1',
                numeric: true,
              },
              {
                name: 'ActMod_trq.MCD.UserAvg',
                measure: 'Nm',
                value: '9.09',
                numeric: true,
              },
              {
                name: 'ActMod_trqCrS.MCD.UserAvg',
                measure: 'Nm',
                value: '9.05',
                numeric: true,
              },
              {
                name: 'APP_r.MCD.UserAvg',
                measure: '%',
                value: '0.00',
                numeric: true,
              },
              {
                name: 'BattU_u.MCD.UserAvg',
                measure: 'mV',
                value: '13493.60',
                numeric: true,
              },
              {
                name: 'CEngDsT_t.MCD.UserAvg',
                measure: '°C',
                value: '62.01',
                numeric: true,
              },
              {
                name: 'CEngDsT_t_CHdT.MCD.UserAvg',
                measure: '°C',
                value: '50.71',
                numeric: true,
              },
              {
                name: 'CHdT_t.MCD.UserAvg',
                measure: '°C',
                value: '62.02',
                numeric: true,
              },
              {
                name: 'CHdT_uRaw.MCD.UserAvg',
                measure: 'V',
                value: '1.80',
                numeric: true,
              },
              {
                name: 'CoEng_bHEM.MCD.UserAvg',
                value: '0',
                numeric: true,
              },
              {
                name: 'CoTE_tEngCoDem_VW.MCD.UserAvg',
                measure: '°C',
                value: '105.00',
                numeric: true,
              },
              {
                name: 'CThmst_r.MCD.UserAvg',
                measure: '%',
                value: '0.00',
                numeric: true,
              },
              {
                name: 'Epm_nEng.MCD.UserAvg',
                measure: 'rpm',
                value: '698.57',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiCaSOfsAvg0.MCD.UserAvg',
                measure: '°KW',
                value: '-1.93',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiCaSOfsAvg1.MCD.UserAvg',
                measure: '°KW',
                value: '-1.23',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiCaSOfsAvg2.MCD.UserAvg',
                measure: '°KW',
                value: '3.21',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiCaSOfsAvg3.MCD.UserAvg',
                measure: '°KW',
                value: '2.86',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiDiffCal2AdapEqAvg0.MCD.UserAvg',
                measure: '°KW',
                value: '-1.41',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiDiffCal2AdapEqAvg1.MCD.UserAvg',
                measure: '°KW',
                value: '-0.94',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiDiffCal2AdapEqAvg2.MCD.UserAvg',
                measure: '°KW',
                value: '2.64',
                numeric: true,
              },
              {
                name: 'EpmCaS_phiDiffCal2AdapEqAvg3.MCD.UserAvg',
                measure: '°KW',
                value: '2.29',
                numeric: true,
              },
              {
                name: 'ExhMod_tExhVlvB1.MCD.UserAvg',
                measure: '°C',
                value: '430.59',
                numeric: true,
              },
              {
                name: 'ExhMod_tExhVlvB2.MCD.UserAvg',
                measure: '°C',
                value: '430.59',
                numeric: true,
              },
              {
                name: 'fkmsdkb1_w_msg.MCD.UserAvg',
                value: '0.988',
                numeric: true,
              },
              {
                name: 'fkmsdkb2_w_msg.MCD.UserAvg',
                value: '0.974',
                numeric: true,
              },
              {
                name: 'fr2_w_msg.MCD.UserAvg',
                value: '1.113',
                numeric: true,
              },
              {
                name: 'fr_w_msg.MCD.UserAvg',
                value: '1.045',
                numeric: true,
              },
              {
                name: 'fra2_w.MCD.UserAvg',
                value: '1.000',
                numeric: true,
              },
              {
                name: 'fra_w.MCD.UserAvg',
                value: '1.000',
                numeric: true,
              },
              {
                name: 'frm2_w.MCD.UserAvg',
                value: '1.113',
                numeric: true,
              },
              {
                name: 'frm_w.MCD.UserAvg',
                value: '1.046',
                numeric: true,
              },
            ],
          },
        ],
      };

      const data = response.records[0].records.reduce(
        (acc, record) => {
          acc.labels.push(record.name);
          acc.data.push(record.value);

          return acc;
        },
        { labels: [], data: [] }
      );

      new Chart(document.getElementById('horizontalBar'), {
        type: 'horizontalBar',
        data: {
          labels: data.labels,
          datasets: [
            {
              label: 'Record report',
              data: data.data,
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
            },
          ],
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
      //   });
    </script>
  </body>
</html>
