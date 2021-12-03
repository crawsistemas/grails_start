/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function mascaraNumero(campo){
        var v=campo.value;
        v=v.replace(/\D/g,"");
        
        if (v.trim() === "")
            v = '0';

        if(v.length > 2) {
                if (v[0]==='0' && v.length>3)
                    v = v.substr(1,v.length);
                
                if(v.length < 6) {                   
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else if (v.length < 9) {
                                v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else if (v.length < 12) {
                                v = v.replace(/(\d{0})(\d{8})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else if (v.length < 15) {
                                v = v.replace(/(\d{0})(\d{11})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{8})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else {
                    v = v.substr(0,14);
                    v = v.replace(/(\d{0})(\d{11})$/,"$1.$2");
                    v = v.replace(/(\d{0})(\d{8})$/,"$1.$2");
                    v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                    v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
        }
        else {
                if(v.length === 1)
                    v = '0,0' + v;
                else if (v.length === 2)
                    v = '0,' + v;
        }
        campo.value = v;
}

function mascaraNumeroNegativo(campo){
        var v=campo.value;
        var negativo=false;
        if(v.indexOf("-") > -1)
            negativo=true;
        v=v.replace(/\D/g,"");
        
        if (v.trim() === "")
            v = '0';

        if(v.length > 2) {
                if (v[0]==='0' && v.length>3)
                    v = v.substr(1,v.length);
                
                if(v.length < 6) {                   
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else if (v.length < 9) {
                                v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else if (v.length < 12) {
                                v = v.replace(/(\d{0})(\d{8})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else if (v.length < 15) {
                                v = v.replace(/(\d{0})(\d{11})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{8})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                                v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
                else {
                    v = v.substr(0,14);
                    v = v.replace(/(\d{0})(\d{11})$/,"$1.$2");
                    v = v.replace(/(\d{0})(\d{8})$/,"$1.$2");
                    v = v.replace(/(\d{0})(\d{5})$/,"$1.$2");
                    v = v.replace(/(\d{0})(\d{1,2})$/,"$1,$2");
                }
        }
        else {
                if(v.length === 1)
                    v = '0,0' + v;
                else if (v.length === 2)
                    v = '0,' + v;
        }
        if(negativo && v!='0,00'){
            v = '-'+v;
        }
        campo.value = v;
}