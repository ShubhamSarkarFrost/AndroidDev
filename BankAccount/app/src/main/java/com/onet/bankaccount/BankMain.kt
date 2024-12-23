package com.onet.bankaccount


fun main() {

    val denisesBankAccount = BankAccount("Denis Panjuta", 1338.20)

    denisesBankAccount.deposit(200.0)
    denisesBankAccount.withdraw(1200.00)
    denisesBankAccount.deposit(3000.00)
    denisesBankAccount.deposit(2000.00)
    denisesBankAccount.withdraw(3333.15)

    denisesBankAccount.displayTransactionHistory()
    println(
        "${denisesBankAccount.accountHolder}'s " +
                "balance is ${denisesBankAccount.accBalance()}"
    )

    //new user Sarah
    val sarahBankAccount = BankAccount("Sarah Goldstien", 0.0)

    sarahBankAccount.deposit(100.0)
    sarahBankAccount.withdraw(10.0)
    sarahBankAccount.deposit(300.0)

    sarahBankAccount.displayTransactionHistory()
    println(
        "${sarahBankAccount.accountHolder}'s " +
                "balance is ${sarahBankAccount.accBalance()}"
    )

}
