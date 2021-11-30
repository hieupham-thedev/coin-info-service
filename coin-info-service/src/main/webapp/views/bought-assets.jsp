<div class="col-sm-9 main">
    <table id="myTable" class="table table-striped table-bordered">
    </table>
    <script>
        $(document).ready(function () {
            $('#myTable').DataTable({
                ajax: {
                    url: '${pageContext.request.contextPath}/api/asset/getBoughtAssets',
                    method: 'POST',
                    dataSrc: ''
                },
                columnDefs: [{
                    targets: "_all",
                    defaultContent: ""
                }],
                columns: [
                    {
                        data: 'icon_url',
                        render: function (data) {
                            return `<img src="` + data + `" alt="coin_img"/>`;
                        },
                        title: 'Icon'
                    },
                    {
                        data: 'asset_id',
                        title: 'Asset ID'
                    },
                    {
                        data: 'bought_usd',
                        title: 'Bought Price (USD)'
                    },
                    {
                        data: 'current_usd',
                        title: 'Current Price (USD)'
                    },
                    {
                        title: 'Interest',
                        render: function (data, type, row) {
                            let interest = row.current_usd - row.bought_usd;
                            interest = (Math.round(interest * 100) / 100).toFixed(2);
                            if (interest > 0) {
                                return `<span class="btn btn-success">+`+ interest +`</span>`;
                            } else if (interest < 0) {
                                return `<span class="btn btn-danger">`+ interest +`</span>`;
                            } else {
                                return `<span class="btn btn-warning">`+ interest +`</span>`;
                            }
                        }
                    },
                ],
                responsive: true
            });
        });
    </script>
</div>


