/* 
    Ŀ�ģ����Խ�һ����Ʒ���ڲ�����Ͳ�Ʒ�����ɹ��̷ֿ�(����Ʒ�Ľ����ⲿ��)���Ӷ���ʹһ������������ɲ�ͬ�ڲ�����Ĳ�Ʒ����
	���ƣ������ÿͻ��˺��Բ�Ʒ���ڲ�����Ľ���
	ʹ�ó�������һ�������ĳЩ��Ҫ���ʣ���û��ǡ����ֵǰ����������Ϊһ�������Ĳ�Ʒ
	                 ��һ����������ʵĸ�ֵ���밴��ĳ��˳��
					 ��ʱ�����൱��һ�������Ĳ�Ʒ������Щ�����൱�ڲ�Ʒ�����
*/
// ��Ʒ����������Ǽ򵥵�����Ҳ�����Ƕ���
/*
    �ж��ٸ�����Ĳ�Ʒ����ж��ٸ�����Ľ������࣬��Щ��Ʒ����ͬ���������Ŀ�������Ʒû��ͬ����
	 �����Ŀ���Խ��ٵ�����Ĳ�Ʒ����Ӧ�ľ��彨����ʹ�ÿյĹ����������(buildPartA)
*/
// ����Ĳ�Ʒ��һ��û����ϵ(�������ϵ),���һ��ʹ��һ����ʶ�ӿ�(Product)��Ϊ�����߽ӿ��з���retrieveResult�ķ���ֵ
/*
�����Ʒ���ǵ������Ĳ��ܼ����ʶ�ӿڣ���Ӧ�ý�����������retrieveResult����ȥ��������ÿ������Ľ�����������ʵ�֣�
���ز�ͬ���������͡�Director��Ҫ����retrieveResult����ʱ�����ڱ������õ�����������Builder���������������ת��Ϊ
����Ľ��������࣬�Ӷ����Ե���retrieveResult
*/
// �˻��Ľ�����ģʽ����û�г������ߢ�û�е����ߢ�ģ�巽���ܲ�Ʒ��ͽ����ߺϲ�(�����ڶ���ֻ�й̶�������������������Ĵ����ߺͶ�����)
// JDK�е�java.lang.StringBuilder.append(Object obj); ʹ���˸�ģʽ�򻯸��ӵĶ���Ĵ���
public class Main {
     public static void main(String[] args) {
	     // �����彨���ߺ͵����߶��󽻸��ͻ��˹��죬�����彨���߽����ͻ��˹�������ǵ����߿��Խ���ϱ�Ϊ��̬��
	     Builder b = new ConcreteBuilder();
		 Director director = new Director(b);
		 Product p = director.construct();
	 }
}

���ʹ�ý�����ģʽ(Builder Pattern)�������ɱ���
����ѡ�ĳ�Ա�����ܶ��ʱ��ʹ�ý�����ģʽ�������ɱ����ǲ���ķ���
1��code��
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
2��test code
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

�ֲ�����ģʽ
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

