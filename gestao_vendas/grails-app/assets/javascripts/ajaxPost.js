function ajaxPost(element, url, nomeDivUpdate, bloquear, tentativa) {
    bloquear = ajaxPost.arguments.length<4 ? true : bloquear;
    tentativa = ajaxPost.arguments.length<5 ? 1 : tentativa;

    var form=null, formData = null, contentType = "application/x-www-form-urlencoded", processData = true, divUpdate=$(null);

    if (element) {
        form = $(element.form);        
        formData = $(form).serialize();
    }
    if(nomeDivUpdate)
        divUpdate = $("#"+nomeDivUpdate.replace( /(:|\.|\[|\]|,|=|@)/g, "\\$1" ));
    var divBlock = $( "<div>" ).attr( "id", nomeDivUpdate+"-block" )
        .addClass( "bloqueio-div" )
        .append( '<div class="spinner"></div>' );

    $.ajax({
        type: "POST",
        url: url,
        cache: false,
        data: formData,
        contentType: contentType,
        processData: processData,
        timeout: 0, //Set your timeout value in milliseconds or 0 for unlimited
        beforeSend: function() {
            if (bloquear) {
                divBlock.prependTo( divUpdate );
                $(form).find(":input[type=submit]:enabled,button[type=button]:enabled").attr("disableAjax",true).attr('disabled',true);
                $(form).bind('keydown', function(event) {
                    if (event.which === 13) {
                        event.preventDefault();
                        return false;
                    }
                });
            }
        },
        success: function(res){
            divUpdate.html(res);
        },
        error: function(xhr, status, error){
            console.log("Erro Ajax:"+status);
            console.log("Tentou "+tentativa+" vez(es).");
            if (tentativa<3)
                ajaxPost(element, url, nomeDivUpdate, bloquear, tentativa+1);
            else
                alert("Erro ao carregar dados. Conexão com a internet falhou(timeout)."+error);
        },
        complete: function(e){
            if (bloquear) {
                divBlock.remove();
                if ($(form).find(".bloqueio-div").length===0) {
                    $(form).find(":input[type=submit][disableAjax=true],button[type=button][disableAjax=true]").removeAttr("disableAjax").removeAttr('disabled');
                    $(form).unbind('keydown');
                }
            }
        }
    });
}