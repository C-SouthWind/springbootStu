package com.chj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.Repeatable;

/**
 * @projectName: springboot
 * @package: com.chj
 * @className: Springboot0103QuickstartApplication
 * @author: chj
 * @description:
 * @date: Created in  2023/2/14 20:19
 * @version: 1.0
 */


/**
 * 自动配置的原理
 * 1、收集Spring开发者的编程习惯，整理开发过程使用的常用技术列表-》（技术集A）
 * 2、收集常用技术（技术集A）的使用参数，整理开发过程中每个技术的常用设置列表-》（设计集B）
 * 3、初始化SpringBoot基础环境，加载用户自定义的bean和导入的其他坐标，形成初始化环境
 * 4、将技术集A包含的所有技术都定义出来，在Spring/SpringBoot启动时默认全部加载
 * //对应的源码 将LOCATION = META-INF/spring/%s.imports 中的配置加载到内存中
 * 5、将技术集A中具有使用条件的技术约定出来，设置成按条件加载，由开发者决定是否使用该技术（与初始环境对比 ：第三条）
 * //可以阅读RedisAutoConfiguration文件查看是否全部看懂
 * 6、将设置集B作为默认配置加载（约定大于配置），减少开发者配置工作量（xxxProperties中有设置好的默认值）
 * 7、开放设置集B的配置覆盖接口，由开发者根据自身需要决定是否覆盖默认值 （application.yml中配置可以覆盖xxxProperties）
 */
@SpringBootApplication

@SpringBootConfiguration
@Configuration
@Component
@Indexed //加速启动的（程序启动的时候慢，根据启动的过程创建一个全新的文件，加载bean的时候加载这个文件里面的东西，速度会快）

@EnableAutoConfiguration//自动配置开关
@AutoConfigurationPackage
@Import({AutoConfigurationPackages.Registrar.class})
@Import({AutoConfigurationImportSelector.class})
//xxxImportSelector 参考springboot_26_bean_init com.chj.bean.MyImportSelector

@ComponentScan(
        excludeFilters = {
                //磁盘扫描的过滤器  满足就不扫描了（扫完之后这些东西就不要了）
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {TypeExcludeFilter.class}), //按照类型排除过滤器
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {AutoConfigurationExcludeFilter.class} //自动配置排除过滤器
                )}
)
@Repeatable(ComponentScans.class) //读取多个Component


/**
 * Registrar实现了ImportBeanDefinitionRegistrar  //xxxRegistrar 参考springboot_26_bean_init com.chj.bean.MyRegistrar
 *
 *   @Override
 *   public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
 *          //new PackageImports(metadata).getPackageNames() 运行结果 com.chj (好像是获取了当前到包？)
 *          //BeanDefinitionRegistry registry 可以对bean进行操作   他操作了什么？
 *          //metadata 元数据 这个类被哪个类import导入 就可以获取当前类的所有信息   springboot拿这个干什么的？ 好像是在new PackageImports(metadata)的时候用 原来是拿到当前路径
 * 			register(registry, new PackageImports(metadata).getPackageNames().toArray(new String[0])); //这个方法做了什么？
 *   }
 *
 *
 *   public static void register(BeanDefinitionRegistry registry, String... packageNames) {
 *      //当前注册器里面（也就是registry） 是否包含一个bean  这个bean是什么呢？   private static final String BEAN = AutoConfigurationPackages.class.getName(); 原来是AutoConfigurationPackages的全限定名
 *      //
 * 		if (registry.containsBeanDefinition(BEAN)) {
 * 			addBasePackages(registry.getBeanDefinition(BEAN), packageNames);
 *                }
 * 		else {
 * 		    //第一次启动居然走了这里，因为没有加载AutoConfigurationPackages 这个bean么？  好吧 springboot下面要做什么呢？
 *
 *          //设置了一个包信息 底层就一行代码 setBeanClass(beanClass)
 * 			RootBeanDefinition beanDefinition = new RootBeanDefinition(BasePackages.class);
 * 		    //设置权限？什么权限
 * 			beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
 * 	        //把传过来的	packageNames传到了这个对象里 为什么？ springboot要干嘛
 * 	        //要扫那些包 总要知道扫描扫描吧  不然也扫不到呀  因为可以设定扫不同的包  所以叫add 不叫set
 * 			addBasePackages(beanDefinition, packageNames);
 *
 * 	        //springboot 如果没有这个bean 居然把这个bean加载进去了  可以参考springboot_26_bean_init com.chj.bean.MyRegistrar中怎么操作的
 * 			registry.registerBeanDefinition(BEAN, beanDefinition);
 *        }
 *
 *  原来@Import({AutoConfigurationPackages.Registrar.class}) 就是设置当前所在的包作为扫描包，后续要针对当前包进行扫描
 */
@Import({AutoConfigurationPackages.Registrar.class})


/**
 *
 * 实现这么多接口 其实可以分为三大类
 * 1、BeanClassLoaderAware（bean类加载器）, ResourceLoaderAware（资源加载器）, BeanFactoryAware（bean工厂）,EnvironmentAware(环境)  Aware结尾的
 *          Aware什么意思呢？  参考springboot_28_bean_properties com.chj.bean.Wolf  Aware使用需要这个类被加载
 *          那么加载了么？ 当然被加载了 @Import({AutoConfigurationImportSelector.class})
 *          可以保证这套环境中有这些Aware这些对象 想用可以用
 * 2、Ordered
 *          springboot中类加载的加载顺序 为什么要有这个设定呀？  假设加载50个bean  加载第51的时候 需要前面加载完才进行加载 那么就可以设置加载顺序了 加载的顺序很关键
 * 3、DeferredImportSelector
 *          推迟的导入加载器？ 那他加载的时候肯定比较晚才叫延迟加载器吧
 *          public interface DeferredImportSelector extends ImportSelector  原来实现了这个啊 可以参考springboot_26_bean_init com.chj.bean.MyImportSelector
 *          springboot要延迟加载什么呢？
 *
 *          DeferredImportSelector中居然还有一个内部接口类  interface Group
 *          Group:组   看来要延迟加载好多呀
 *          Group接口中有这个方法很重要
 *          void process(AnnotationMetadata metadata, DeferredImportSelector selector)
 *
 *          在AutoConfigurationImportSelector实现类中这样实现的
 *
 *          @Override
 *          public void process(AnnotationMetadata annotationMetadata, DeferredImportSelector deferredImportSelector) {
 *                  //断言？  springboot肯定在判断一种情况
 * 			        Assert.state(deferredImportSelector instanceof AutoConfigurationImportSelector,
 * 					    () -> String.format("Only %s implementations are supported, got %s",
 * 							    AutoConfigurationImportSelector.class.getSimpleName(),
 * 							    deferredImportSelector.getClass().getName()));
 *
 *                  //核心
 * 			        AutoConfigurationEntry autoConfigurationEntry = ((AutoConfigurationImportSelector) deferredImportSelector).getAutoConfigurationEntry(annotationMetadata);
 *
 * 			            protected AutoConfigurationEntry getAutoConfigurationEntry(AnnotationMetadata annotationMetadata) {
 * 		                                //判断我们的这个值是否是不可用的  annotationMetadata打印出来是 com.chj.Application
 * 		                                if (!isEnabled(annotationMetadata)) {
 * 			                                return EMPTY_ENTRY;
 *                                      }
 *                                      //获得我们元注解的所有属性 attributes打印出来是  excludeName（按照字符串名称配置）和exclude（按照class类的名称配） 注：自动装配不想用的可以配上     这个两个在哪里呢？ 在getAttributes（）方法里呀
 * 		                                AnnotationAttributes attributes = getAttributes(annotationMetadata);
 * 		                                    protected AnnotationAttributes getAttributes(AnnotationMetadata metadata) {
 * 		                                                String name = getAnnotationClass().getName();
 *                                                          //拿到EnableAutoConfiguration的字节码
 * 		                                                    protected Class<?> getAnnotationClass() {
 * 		                                                        return EnableAutoConfiguration.class;
 *                                                          }
 *
 * 		                                                AnnotationAttributes attributes = AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(name, true));
 * 		                                                Assert.notNull(attributes, () -> "No auto-configuration attributes found. Is " + metadata.getClassName()
 * 				                                            + " annotated with " + ClassUtils.getShortName(name) + "?");
 * 		                                                return attributes;
 *                                          }
 *
 *                                      //获得候选的配置 将LOCATION = META-INF/spring/%s.imports 中的配置加载到内存中
 * 		                                List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);
 *                                          //原来这样实现的
 * 		                                	protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
 * 		                                            List<String> configurations = ImportCandidates.load(AutoConfiguration.class, getBeanClassLoader())
 * 				                                                                                    .getCandidates();
 *
 * 				                                                public static ImportCandidates load(Class<?> annotation, ClassLoader classLoader) {
 * 		                                                                Assert.notNull(annotation, "'annotation' must not be null");
 * 		                                                                ClassLoader classLoaderToUse = decideClassloader(classLoader);
 * 		                                                                 // 原来加载的这个里面的资源 LOCATION = META-INF/spring/%s.imports
 * 		                                                                String location = String.format(LOCATION, annotation.getName());
 * 		                                                                //加载资源
 * 		                                                                Enumeration<URL> urls = findUrlsInClasspath(classLoaderToUse, location);
 * 		                                                                        //使用这个去加载的
 * 		                                                                        private static Enumeration<URL> findUrlsInClasspath(ClassLoader classLoader, String location) {
 *                                                                                		try {
 *                                                                                			return classLoader.getResources(location);
 *                                                                                       }
 *                                                                                		catch (IOException ex) {
 *                                                                                			throw new IllegalArgumentException("Failed to load configurations from location [" + location + "]", ex);
 *                                                                                       }    *
 *                                                                                  }
 * 		                                                                List<String> importCandidates = new ArrayList<>();
 * 		                                                                while (urls.hasMoreElements()) {
 * 			                                                                URL url = urls.nextElement();
 * 			                                                                importCandidates.addAll(readCandidateConfigurations(url));
 *                                                                      }
 * 		                                                                 return new ImportCandidates(importCandidates);
 *                                                                  }

 * 		                                             Assert.notEmpty(configurations,
 * 				                                                    "No auto configuration classes found in "
 * 						                                            + "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports. If you "
 * 						                                            + "are using a custom packaging, make sure that file is correct.");
 * 		                                            return configurations;
 *                                          }
 *
 * 		                                configurations = removeDuplicates(configurations);
 * 		                                Set<String> exclusions = getExclusions(annotationMetadata, attributes);
 * 		                                checkExcludedClasses(configurations, exclusions);
 * 		                                configurations.removeAll(exclusions);
 * 		                                configurations = getConfigurationClassFilter().filter(configurations);
 * 		                                fireAutoConfigurationImportEvents(configurations, exclusions);
 * 		                                return new AutoConfigurationEntry(configurations, exclusions);    * 	}
 *
 *

 *
 *
 * 			        this.autoConfigurationEntries.add(autoConfigurationEntry);
 * 			        for (String importClassName : autoConfigurationEntry.getConfigurations()) {
 * 				        this.entries.putIfAbsent(importClassName, annotationMetadata);
 *                  }
 *          }
 *
 *
 *
 * public class AutoConfigurationImportSelector implements DeferredImportSelector, BeanClassLoaderAware,
 * 		ResourceLoaderAware, BeanFactoryAware, EnvironmentAware, Ordered
 *
 *
 *
 *
 */
@Import({AutoConfigurationImportSelector.class})
//xxxImportSelector 参考springboot_26_bean_init com.chj.bean.MyImportSelector


public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
