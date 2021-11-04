<div class="w-100">
    <table id="myTable" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>asset_id</th>
            <th>name</th>
            <th>type_is_crypto</th>
            <th>data_start</th>
            <th>data_end</th>
            <th>price_usd</th>
        </tr>
        </thead>
    </table>
    <script>
        $(document).ready(function () {
            $('#myTable').DataTable({
                ajax: {
                    url: 'http://localhost:8089/api/asset/getAll',
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
