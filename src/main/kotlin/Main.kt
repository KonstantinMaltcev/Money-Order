const val MIN_COMMISSION = 3500
const val PERCENT = 75


fun main() {
    println("Добрый день")

    var flag = true
    while (flag) {
        print("Ведите сумму перевода: ")
        val line = readLine()?.toInt()
        val transfer = line?.times(100)

        if (transfer!! < 0) {
            println("Вы ввели отрицательное число, введите заново!")
            continue
        } else if (transfer == 0) {
            println("Вы ничего не переводите? Введите корректную сумму!")
        } else {
            val amount =
                if ((transfer / 10000 * PERCENT) > MIN_COMMISSION) (transfer / 10000 * PERCENT) else MIN_COMMISSION
            flag = false
            println("Сумма вашего перевода: ${transfer / 100.00} рублей")
            println("Комиссия за перевод составит: ${amount / 100.00} рублей")
            print("Итого: ${(transfer + amount) / 100.00} рублей")
        }


    }


}

