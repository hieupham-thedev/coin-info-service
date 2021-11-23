<div class="w-100">
    <table id="myTable" class="table table-striped table-bordered">
    </table>
    <script>
        $(document).ready(function () {
            $('#myTable').DataTable({
                ajax: {
                    url: '${pageContext.request.contextPath}/api/asset/getAll',
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
                        data: 'name',
                        title: 'Name'
                    },
                    {
                        data: 'type_is_crypto',
                        render: function (data) {
                            return data ? 'Yes' : 'No';
                        },
                        title: 'Crypto ?'
                    },
                    {
                        data: 'data_start',
                        title: 'Data Start'
                    },
                    {
                        data: 'data_end',
                        title: 'Data End'
                    },
                    {
                        data: 'price_usd',
                        title: 'Price (USD)'
                    },
                ],
                responsive: true
            });
        });

    </script>
</div>
