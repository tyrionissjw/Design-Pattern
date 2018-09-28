/* 
    目的：可以将一个产品的内部表象和产品的生成过程分开(将产品的建造外部化)，从而可使一个建造过程生成不同内部表象的产品对象
	优势：可以让客户端忽略产品的内部表象的建立
	使用场景：①一个对象的某些重要性质，在没有恰当赋值前，对象不能作为一个完整的产品
	                 ②一个对象的性质的赋值必须按照某个顺序
					 此时对象相当于一个待建的产品，而这些性质相当于产品的零件
*/
// 产品的零件可以是简单的类型也可以是对象
/*
    有多少个具体的产品类就有多少个具体的建造者类，这些产品类有同样的零件数目，如果产品没有同样的
	 零件数目，对较少的零件的产品，对应的具体建造者使用空的构造零件方法(buildPartA)
*/
// 具体的产品类一般没有联系(非子类关系),因此一般使用一个标识接口(Product)作为建造者接口中方法retrieveResult的返回值
/*
如果产品类是第三方的不能加如标识接口，就应该将抽象建造者中retrieveResult方法去掉，而在每个具体的建造者子类中实现，
返回不同的子类类型。Director需要调用retrieveResult方法时，由于变量引用的明显类型是Builder，必须对其下向下转型为
具体的建造者子类，从而可以调用retrieveResult
*/
// 退化的建造者模式：①没有抽象建造者②没有导演者③模板方法④产品类和建造者合并(适用于对象只有固定的零件，否则混淆对象的创立者和对象本身)
// JDK中的java.lang.StringBuilder.append(Object obj); 使用了该模式简化复杂的对象的创建
public class Main {
     public static void main(String[] args) {
	     // 将具体建造者和导演者对象交给客户端构造，将具体建造者交给客户端构造而不是导演者可以将耦合变为动态的
	     Builder b = new ConcreteBuilder();
		 Director director = new Director(b);
		 Product p = director.construct();
	 }
}

如何使用建造者模式(Builder Pattern)创建不可变类
当可选的成员变量很多的时候，使用建造者模式创建不可变类是不错的方法
1、code：
public class ImmutableClass {
 
    //required fields
    private int id;
    private String name;
 
    //optional fields
    private HashMap properties;
    private String company;
 
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public HashMap getProperties() {
        //return cloned object to avoid changing it by the client application
        return (HashMap) properties.clone();
    }
 
    public String getCompany() {
        return company;
    }
 
    private ImmutableClass(ImmutableClassBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.properties = builder.properties;
        this.company = builder.company;
    }
 
        //Builder class
    public static class ImmutableClassBuilder{
        //required fields
        private int id;
        private String name;
 
        //optional fields
        private HashMap properties;
        private String company;
 
        public ImmutableClassBuilder(int i, String nm){
            this.id=i;
            this.name=nm;
        }
 
        public ImmutableClassBuilder setProperties(HashMap hm){
            this.properties = (HashMap) hm.clone();
            return this;
        }
 
        public ImmutableClassBuilder setCompany(String comp){
            this.company = comp;
            return this;
        }
 
        public ImmutableClass build(){
            return new ImmutableClass(this);
        }
    }
}
2、test code
public class ImmutableBuilderTest {
 
    public static void main(String[] args) {
 
        // Getting immutable class only with required parameters
        ImmutableClass immutableClass = new ImmutableClass.ImmutableClassBuilder(1, "Pankaj").build();
 
        HashMap hm = new HashMap();
        hm.put("Name", "Pankaj");
        hm.put("City", "San Jose");
        // Getting immutable class with optional parameters
        ImmutableClass immutableClass1 = new ImmutableClass.ImmutableClassBuilder(1, "Pankaj")
                                                     .setCompany("Apple").setProperties(hm).build();
 
        //Testing immutability
        HashMap hm1 = immutableClass1.getProperties();
 
        //lets modify the Object passed as argument or get from the Object
        hm1.put("test", "test");
 
        //check that immutable class properties are not changed
        System.out.println(immutableClass1.getProperties());
    }
 
}

分部建造模式
public class CharacterStepBuilder {

	private CharacterStepBuilder() {
	}

	public static NameStep newBuilder() {
		return new CharacterSteps();
	}

	/**
	 * First Builder Step in charge of the Character name.
	 * Next Step available : ClassStep
	 */
	public interface NameStep {
		ClassStep name(String name);
	}

	/**
	 * This step is in charge of setting the Character class (fighter or wizard).
	 * Fighter choice : Next Step available : WeaponStep
	 * Wizard choice : Next Step available : SpellStep
	 */
	public interface ClassStep {
		WeaponStep fighterClass(String fighterClass);
		SpellStep wizardClass(String wizardClass);
	}

	/**
	 * This step is in charge of the weapon.
	 * Weapon choice : Next Step available : AbilityStep
	 * No weapon choice : Next Step available : BuildStep
	 */
	public interface WeaponStep {
		AbilityStep withWeapon(String weapon);
		BuildStep noWeapon();
	}

	/**
	 * This step is in charge of the spell.
	 * Spell choice : Next Step available : AbilityStep
	 * No spell choice : Next Step available : BuildStep
	 */
	public interface SpellStep {
		AbilityStep withSpell(String spell);
		BuildStep noSpell();
	}

	/**
	 * This step is in charge of abilities.
	 * Next Step available : BuildStep
	 */
	public interface AbilityStep {
		AbilityStep withAbility(String ability);
		BuildStep noMoreAbilities();
		BuildStep noAbilities();
	}

	/**
	 * This is the final step in charge of building the Character Object.
	 * Validation should be here.
	 */
	public interface BuildStep {
		Character build();
	}


	/**
	 * Step Builder implementation.
	 */
	private static class CharacterSteps
	    implements NameStep, ClassStep, WeaponStep, SpellStep, AbilityStep, BuildStep {

		private String name;
		private String fighterClass;
		private String wizardClass;
		private String weapon;
		private String spell;
		private List<String> abilities = new ArrayList<>();

		@Override
		public ClassStep name(String name) {
			this.name = name;
			return this;
		}

		@Override
		public WeaponStep fighterClass(String fighterClass) {
			this.fighterClass = fighterClass;
			return this;
		}

		@Override
		public SpellStep wizardClass(String wizardClass) {
			this.wizardClass = wizardClass;
			return this;
		}

		@Override
		public AbilityStep withWeapon(String weapon) {
			this.weapon = weapon;
			return this;
		}

		@Override
		public BuildStep noWeapon() {
			return this;
		}

		@Override
		public AbilityStep withSpell(String spell) {
			this.spell = spell;
			return this;
		}

		@Override
		public BuildStep noSpell() {
			return this;
		}

		@Override
		public AbilityStep withAbility(String ability) {
			this.abilities.add(ability);
			return this;
		}

		@Override
		public BuildStep noMoreAbilities() {
			return this;
		}

		@Override
		public BuildStep noAbilities() {
			return this;
		}

		@Override
		public Character build() {
			Character character = new Character(name);

			if (fighterClass != null) {
				character.setFighterClass(fighterClass);
			} else {
				character.setWizardClass(wizardClass);
			}

			if (weapon != null) {
				character.setWeapon(weapon);
			} else {
				character.setSpell(spell);
			}

			if (!abilities.isEmpty()) {
				character.setAbilities(abilities);
			}

			return character;
		}
	}
}

public class App {
	
	/**
	 * Program entry point
	 * @param args command line args
	 */
        public static void main(String[] args) {

                Character warrior = CharacterStepBuilder.newBuilder()
                    .name("Amberjill")
                    .fighterClass("Paladin")
                    .withWeapon("Sword")
                    .noAbilities()
                    .build();

                System.out.println(warrior);

                Character mage = CharacterStepBuilder.newBuilder()
                    .name("Riobard")
                    .wizardClass("Sorcerer")
                    .withSpell("Fireball")
                    .withAbility("Fire Aura")
                    .withAbility("Teleport")
                    .noMoreAbilities()
                    .build();

                System.out.println(mage);

                Character thief = CharacterStepBuilder.newBuilder()
                    .name("Desmond")
                    .fighterClass("Rogue")
                    .noWeapon()
                    .build();

                System.out.println(thief);
        }
}

