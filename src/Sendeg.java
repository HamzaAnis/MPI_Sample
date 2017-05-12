import mpi.*;

public class Sendeg {
	public static void main(String args[]) throws Exception {
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		if (rank == 0) {
			char[] seql = "Hello Slave".toCharArray();
			MPI.COMM_WORLD.Bcast(seql, 0, seql.length, MPI.CHAR, 0);
//			MPI.COMM_WORLD.Send(seql, 0, seql.length, MPI.CHAR, 3, 99);
		} else {
			char[] seql = new char[100];
			MPI.COMM_WORLD.Bcast(seql, 0, seql.length, MPI.CHAR, 0);
//			MPI.COMM_WORLD.Recv(seql, 0, seql.length, MPI.CHAR, 0, 99);
			System.out.println("I am salve "+rank+" of size "+(size-1)+" ");
			System.out.println("Received from master "+new String(seql));
		}
		MPI.Finalize();
	}
}