function countEquasion(a, b) {
    return 3 * a * (8 * b + 5) - 6 * (4 * a * b - 2 * a)
}

document.getElementById("solve").addEventListener("click", () => {
    let a = document.getElementById("a-input").value
    let b = document.getElementById("b-input").value
    document.getElementById("result").innerHTML = countEquasion(a, b)
})

document.getElementById("clear").addEventListener("click", () => {
    document.getElementById("a-input").value = 0
    document.getElementById("b-input").value = 0
    document.getElementById("result").innerHTML = ""
})