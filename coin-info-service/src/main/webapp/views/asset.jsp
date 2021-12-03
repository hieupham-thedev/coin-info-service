<div class="col-sm-9 main">

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
                    {
                        title: 'Action',
                        render: function (data, type, row) {
                            return `<button class="btn btn-primary" onclick="buyAsset('` + row.asset_id + `')">Buy</button>`
                        }
                    },
                ],
                responsive: true
            });

            $("#myTable_length").append(`<a id="exportButton" class="btn btn-success py-0 mx-2" href="${pageContext.request.contextPath}/api/asset/exportExcel">Export</a>`);
        });

        function buyAsset(assetId) {
            Swal.fire({
                title: 'Do you want to buy this asset ?',
                showCancelButton: true,
                confirmButtonText: 'Yes',
                showLoaderOnConfirm: true,
                preConfirm: () => {
                    $.ajax({
                        type: "POST",
                        url: `${pageContext.request.contextPath}/api/asset/buy/` + assetId,
                        success: function(response) {
                            Swal.fire({
                                title: 'Buy asset succeed',
                                icon: 'success',
                                showCloseButton: true,
                            });
                        },
                        error: function (response) {
                            Swal.fire({
                                title: 'Buy asset failed',
                                icon: 'error',
                                showCloseButton: true,
                            });
                        }
                    });
                },
                allowOutsideClick: () => !Swal.isLoading()
            });
        }
    </script>
</div>


