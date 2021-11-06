<div class="w-100">
    <table id="myTable" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Asset ID</th>
            <th>Name</th>
            <th>IsCrypto</th>
            <th>Data Start</th>
            <th>Data End</th>
            <th>Price (USD)</th>
        </tr>
        </thead>
    </table>
    <script>
        $(document).ready(function () {
            $('#myTable').DataTable({
                ajax: {
                    url: '${pageContext.request.contextPath}/api/asset/getAll',
                    method: 'POST',
                    dataSrc: ''
                },
                columns: [
                    { data: 'asset_id' },
                    { data: 'name' },
                    { data: 'type_is_crypto' },
                    { data: 'data_start' },
                    { data: 'data_end' },
                    { data: 'price_usd' },
                ],
                responsive: true
            });
        });

    </script>
</div>
