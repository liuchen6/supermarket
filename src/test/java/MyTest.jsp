<html>
<script>
    const person = {
        name : "liuc",
        eat1 : function (food) {
            console.log(this.name + "爱吃" +food);
        },
        eat2 : food => console.log(person.name + "爱吃" + food),
        eat3(food) {
            console.log(this.name + "爱吃" + food);
        }
    }

    person.eat1("水果");
    person.eat1("蔬菜");
    person.eat1("鸡蛋");

</script>
</html>