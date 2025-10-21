package answer

private class ComputerDetail private constructor(
    val cpu: String,
    val ram: String,
    val storage: String,
    val gpu: String
) {
    class Builder {
        private var cpu: String = "Intel"
        private var ram: String = "8GB"
        private var storage: String = "512GB"
        private var gpu: String = "None"

        fun setCpu(cpu: String) = apply { this.cpu = cpu }
        fun setRam(ram: String) = apply { this.ram = ram }
        fun setStorage(storage: String) = apply { this.storage = storage }
        fun setGpu(gpu: String) = apply { this.gpu = gpu }

        fun build() = ComputerDetail(cpu, ram, storage, gpu)
    }
}

private fun main() {
    val computer = ComputerDetail.Builder().apply {
        setCpu("i5-13500H")
        setRam("16GB")
        setStorage("512GB SSD")
        setGpu("None")
    }.build()

    println("电脑 CPU=${computer.cpu}, RAM=${computer.ram}, GPU=${computer.gpu}")
}

/*
单例模式（全局对象管理）
工厂模式（对象创建解耦）
建造者模式（复杂对象配置）
观察者模式（事件通知：LiveData/Flow）
适配器模式（UI适配：RecyclerView.Adapter）
装饰者模式（OkHttp 拦截器链）
策略模式（LayoutManager、算法替换）
责任链模式（OkHttp 拦截器链）
代理模式（Retrofit 动态代理）
模板方法模式（AsyncTask、Activity 生命周期回调）
享元模式（复用对象，比如 Drawable、RecyclerView 的 ViewHolder 复用）
 */
/*
创建型模式（解决“对象怎么创建”）：单例、工厂、建造者
行为型模式（解决“对象之间怎么交互”）：观察者、策略
结构型模式（解决“类和对象怎么组合”）：适配器、装饰者
 */
