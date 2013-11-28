使用属性编辑器
方法一：
<!--①配置自动注册属性编辑器的CustomEditorConfigurer -->
<bean class="org.springframework.beans.factory.config.CustomEditorConfigurer">
		<property name="customEditors">
			<map>
                   <!--②-1属性编辑器对应的属性类型-->
                   <entry key="com.baobaotao.editor.Car"> 

                         <!--②-2对应的属性编辑器Bean -->
				    <bean class="com.baobaotao.editor.CustomCarEditor" />
				</entry>
			</map>
		</property>
	</bean>
 <bean id="boss" class="com.baobaotao.editor.Boss">
       <property name="name" value="John"/> 
       <!--③该属性将使用②处的属性编辑器完成属性填充操作-->
       <property name="car" value="红旗CA72,200,20000.00"/> 
</bean>

在①处，我们定义了用于注册自定义属性编辑器的CustomEditorConfigurer，Spring容器将通过反射机制自动调用这个Bean。
CustomEditorConfigurer通过一个Map属性定义需要自动注册的自定义属性编辑器。
在②处，我们为Car类型指定了对应属性编辑器CustomCarEditor，注意键是属性类型，
而值是对应的属性编辑器Bean，而不是属性编辑器的类名。 

最精彩的部分当然是③处的配置，我们原来通过一个<bean>元素标签配置好car Bean，
然后在boss的<bean>中通过ref引用car Bean，但是现在我们直接通过value为car属性提供配置。
BeanWrapper在设置boss的car属性时，它将检索自定义属性编辑器的注册表，
当发现Car属性类型拥有对应的属性编辑器CustomCarEditor时，
它就会利用CustomCarEditor将“红旗CA72,200,20000.00”转换为Car对象。 


方法二：
按照JavaBeans的规范，JavaBeans的基础设施会在JavaBean相同类包下查找是否存在<JavaBean>Editor的类，
如果存在，自动使用<JavaBean>Editor作为该JavaBean的PropertyEditor。 
如com.jianbage.tecstu.javaforspring.springioc.propertyeditor.demo2.CarEditor
会自动成为com.jianbage.tecstu.javaforspring.springioc.propertyeditor.demo2.Car
对应的PropertyEditor。
Spring也支持这个规范，也即如果采用这种规约命令PropertyEditor，
就无须显式在CustomEditorConfigurer中注册了，Spring将自动查找并注册这个PropertyEditor。