module bank

sig Banco{
    // Quer dizer que possui 0 ou mais contas
    // Se colocar one quer dizer que possue uma
    contas: set Conta 


}

sig Conta{

}

sig Poupanca extends Conta{}
sig ContaCorrente extends Conta{}

sig ContaVip in Conta{}

fact formulas{
    #Banco > 1
    all b: Banco | some b.contas
    all c: Conta | one c.~contas
}

pred temContas[b:Banco]{
    some b.contas
}

pred show(){}

run show for 5