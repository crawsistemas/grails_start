<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cliente.label', default: 'Cliente')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>

        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" type="text/css" />
    </head>
    <body>
        <a href="#list-cliente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-cliente" class="content" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            
            <table id="table-cliente">
                <thead>
                    <tr>
                        <th>
                            Ações
                        </th>
                        <th>
                            <g:message code="id" defaul="id" />
                        </th>
                        <th>
                            <g:message code="cliente.nome.label" default="Nome" />
                        </th>
                        <th>
                            <g:message code="cliente.cpfCnpj.label" default="CPF/CNPJ" />
                        </th>
                        <th>
                            <g:message code = "cliente.email.label" defaul="Email" />
                        </th>
                    </tr>
                </thead>
            </table>
        </div>

        <content tag="jsEspecifico">
            <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
            <script>
                $('#table-cliente').DataTable( {
                    "processing": true,
                    "serverSide": true,
                    "ajax": "${createLink(controller:"cliente", action:"listCliente")}",
                    "columns": [
                        {
                            "orderable": false,
                            "data": null,
                            "render": function (data, type, full, meta) { return '<a href="${createLink(controller:'cliente', action:'edit')}/'+ data.id +'" >Editar</a>'; }
                        },
                        {
                            "data":"id"
                        },
                        {
                            "data": "nome"
                        },
                        {
                            "data": "cpfCnpj"
                        },
                        {
                            "data": "email"
                        }
                    ],
                    "language": {
                        "url": "${assetPath(src: 'portuguese-brasil-datatable.json')}"
                    }
                } );
            </script>
	    </content>
    </body>
</html>