import mpi.*;
public class Sendeg{
	public static void main(String args[])throws Exception{
		MPI.Init(args);
		int rank=MPI.COMM_WORLD.Rank();
		int me =MPI.COMM_WORLD.Rank();
		int size=MPI.COMM_WORLD.Size();
		if(rank==0){
			char[] seql="Hello Slave".toCharArray();
		}
//		System.out.println("Hello from <"+me+"> of total <"+size+">");
		MPI.Finalize();
	}
}