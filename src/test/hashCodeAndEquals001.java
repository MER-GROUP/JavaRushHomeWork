package test;

import java.util.Objects;

/**
 * Created by maxim on 02.09.2015.
 */
public class hashCodeAndEquals001 {
    public static void main(String[] args) {
        Object object=new Object();
        int hCode;
        hCode=object.hashCode();
        System.out.println(hCode);
        System.out.println("-----------------");

        BlackBox object1=new BlackBox(5,10);
        BlackBox object2=new BlackBox(5,10);

        System.out.println("object1.equals(object2) = "+object1.equals(object2));
        System.out.println("object1.hashCode() = "+object1.hashCode());
        System.out.println("object2.hashCode() = "+object2.hashCode());
        System.out.println();

        BlackBox object3=new BlackBox(5,10);
        BlackBox object4=object3;
        System.out.println("object3.equals(object4) = "+object3.equals(object4));
        System.out.println("object3.hashCode() = "+object3.hashCode());
        System.out.println("object4.hashCode() = "+object4.hashCode());
        System.out.println();

        System.out.println(object4);
    }
}

class BlackBox{
    int varA;
    int varB;

    public BlackBox(int varA, int varB) {
        this.varA = varA;
        this.varB = varB;
    }

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BlackBox blackBox = (BlackBox) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(varA, blackBox.varA)
                .append(varB, blackBox.varB)
                .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(varA)
                .append(varB)
                .toHashCode();
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BlackBox blackBox = (BlackBox) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(varA, blackBox.varA)
                .append(varB, blackBox.varB)
                .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(varA)
                .append(varB)
                .toHashCode();
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackBox blackBox = (BlackBox) o;
        return com.google.common.base.Objects.equal(varA, blackBox.varA) &&
                com.google.common.base.Objects.equal(varB, blackBox.varB);
    }

    @Override
    public int hashCode()
    {
        return com.google.common.base.Objects.hashCode(varA, varB);
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackBox blackBox = (BlackBox) o;
        return Objects.equals(varA, blackBox.varA) &&
                Objects.equals(varB, blackBox.varB);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(varA, varB);
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BlackBox)) return false;
        BlackBox blackBox = (BlackBox) o;
        return Objects.equals(varA, blackBox.varA) &&
                Objects.equals(varB, blackBox.varB);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(varA, varB);
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackBox blackBox = (BlackBox) o;
        return Objects.equals(varA, blackBox.varA) &&
                Objects.equals(varB, blackBox.varB);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(varA, varB);
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BlackBox)) return false;
        BlackBox blackBox = (BlackBox) o;
        return Objects.equals(varA, blackBox.varA) &&
                Objects.equals(varB, blackBox.varB);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(varA, varB);
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlackBox blackBox = (BlackBox) o;

        if (varA != blackBox.varA) return false;
        return varB == blackBox.varB;

    }

    @Override
    public int hashCode()
    {
        int result = varA;
        result = 31 * result + varB;
        return result;
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BlackBox)) return false;

        BlackBox blackBox = (BlackBox) o;

        if (varA != blackBox.varA) return false;
        return varB == blackBox.varB;

    }

    @Override
    public int hashCode()
    {
        int result = varA;
        result = 31 * result + varB;
        return result;
    }
    */

    /*
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlackBox blackBox = (BlackBox) o;

        if (varA != blackBox.varA) return false;
        return varB == blackBox.varB;

    }

    @Override
    public int hashCode()
    {
        int result = varA;
        result = 31 * result + varB;
        return result;
    }
    */

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof BlackBox)) return false;

        BlackBox blackBox = (BlackBox) o;

        if (varA != blackBox.varA) return false;
        return varB == blackBox.varB;

    }

    @Override
    public int hashCode()
    {
        int result = varA;
        result = 31 * result + varB;
        return result;
    }

    @Override
    public String toString()
    {
        return "BlackBox{" +
                "varA=" + varA +
                ", varB=" + varB +
                '}';
    }

}
