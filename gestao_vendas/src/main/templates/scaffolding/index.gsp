<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>

        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" type="text/css" />
    </head>
    <body>
        <a href="#list-${propertyName}" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="\${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-${propertyName}" class="content" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="\${flash.message}">
                <div class="message" role="status">\${flash.message}</div>
            </g:if>
            
            <table id="table-${propertyName}">
                <thead>
                    <tr>
                        <th>
                            Ações
                        </th>
                        <th>
                            <g:message code="produto.id.label" default="id" />
                        </th>
                    </tr>
                </thead>
            </table>
        </div>

        <content tag="jsEspecifico">
            <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
            <script>
                \$('#table-${propertyName}').DataTable( {
                    "processing": true,
                    "serverSide": true,
                    "ajax": "\${createLink(controller:"produto", action:"listProduto")}",
                    "columns": [
                        {
                            "orderable": false,
                            "data": null,
                            "render": function (data, type, full, meta) { return '<a href="\${createLink(controller:'${propertyName}', action:'edit')}/'+ data.id +'" >Editar</a>'; }
                        },
                        {
                            "data": "id"
                        }
                    ],
                    "language": {
                        "url": "\${assetPath(src: 'portuguese-brasil-datatable.json')}"
                    }
                } );
            </script>
	    </content>
    </body>
</html>