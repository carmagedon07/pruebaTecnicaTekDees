$(document).ready(function () {
    console.log("hola");

    $(function () {
        $("#jsGrid1").jsGrid({
            height: "90%",
            width: "90%",

            sorting: true,
            paging: true,

            //data: db.clients,

            fields: [
                { name: "Producto", type: "text", width: 75 },
                { name: "Cantidad", type: "number", width: 150 },
                { name: "Costo total", type: "text", width: 200 },
                { name: "Estado pedido", type: "text", width: 200 },
                { name: "Acciones", type: "text", width: 200 },

            ]
        });
    });
});