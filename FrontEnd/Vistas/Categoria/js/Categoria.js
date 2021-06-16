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
                { name: "Nombre Categoria", type: "text", width: 75 },
                { name: "Descripcion", type: "number", width: 150 },
                { name: "Accion", type: "text", width: 200 },

            ]
        });
    });
});