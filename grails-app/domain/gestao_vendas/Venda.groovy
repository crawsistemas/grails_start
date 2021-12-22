package gestao_vendas

class Venda {

    //----- ATRIBUTOS ------
    Cliente cliente 
    ArrayList<VendaItem> itensLista = new ArrayList();
    BigDecimal valorTotal

    //----- RELAÇÕES ------
    //static hasMany = [vendaItem:VendaItem] //NECESSARIO?????
    static belongsTo = Cliente

    //----- CONTRAINTS -----
    static constraints = {
        cliente (nullable:false)
        valorTotal (nullable:false,validator:{val,obj-> val > 0}) //SETADO PELO CONTROLLER
        // itensVenda(nullable:false,validator:{val,obj-> !val.isEmpity()})

    }

    // ------ SETTERS E GETTERS ------

    public ArrayList<VendaItem> getItensLista(){
        return itensLista
    }

    public void setItenLista(VendaItem vendaItens){
        itensLista.add(vendaItens)
    }

    // ------FIM SETTERS E GETTERS ------

    // ----- MAPS ----- 
    static mapping = {
        id generator:'sequence', params:[sequence:'sequence_venda']
    }

}

