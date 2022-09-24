package jdbc_maven;

public class TestStudentDriver {
	public static void main(String[] args) {
		TestSelectStudent tss = new TestSelectStudent();
		System.out.println(tss);
	}

	@Override
	public String toString() {
		return "TestStudentDriver []";
	}
}
