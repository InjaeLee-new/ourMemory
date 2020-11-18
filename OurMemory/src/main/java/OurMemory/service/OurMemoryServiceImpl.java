package OurMemory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contact.dao.ContactDAO;
import contact.dto.ContactDTO;
import member.dao.MemberDAO;
import member.dto.MemberDTO;
import memory.dao.MemoryDAO;
import memory.dto.MemoryDTO;
import showoff.dao.ShowoffDAO;
import showoff.dto.ShowoffDTO;

@Service
public class OurMemoryServiceImpl implements OurMemoryService {
	@Autowired // autowired는 setter를 통해서 bean 객체를 자동 주입할 수 있다.
	private MemoryDAO memoryDao;
	
	@Autowired
	private ShowoffDAO showoffDao;
	
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public int memoryBoardWrite(MemoryDTO memoryDTO) {
		return memoryDao.memoryBoardWrite(memoryDTO);
	}

	@Override
	public List<MemoryDTO> memoryBoardList(int startNum, int endNum) {
		return memoryDao.memoryBoardList(startNum, endNum);
	}

	@Override
	public List<MemoryDTO> memoryBoardMyList(int startNum, int endNum, String id) {
		return memoryDao.memoryBoardMyList(startNum, endNum, id);
	}
	
	@Override
	public int showoffBoardWrite(ShowoffDTO showoffDTO) {
		return showoffDao.showoffBoardWrite(showoffDTO);
	}

	@Override
	public List<ShowoffDTO> showoffBoardList(int startNum, int endNum) {
		return showoffDao.showoffBoardList(startNum, endNum);
	}

	@Override
	public List<ShowoffDTO> showoffBoardMyList(int startNum, int endNum, String id) {
		return showoffDao.showoffBoardMyList(startNum, endNum, id);
	}
	
	@Override
	public int getTotalMemory() {
		return memoryDao.getTotalMemory();
	}
	
	@Override
	public int getMyTotalMemory(String id) {
		return memoryDao.getMyTotalMemory(id);
	}
	
	@Override
	public int getTotalShowoff() {
		return showoffDao.getTotalShowoff();
	}

	@Override
	public int getMyTotalShowoff(String id) {
		return showoffDao.getMyTotalShowoff(id);
	}
	
	@Override
	public MemoryDTO memoryBoardView(int seq) {
		return memoryDao.memoryBoardView(seq);
	}

	@Override
	public ShowoffDTO showoffBoardView(int seq) {
		return showoffDao.showoffBoardView(seq);
	}

	@Override
	public int memoryBoardHit(int memory_num) {
		return memoryDao.memoryBoardHit(memory_num);
	}

	@Override
	public int showoffBoardHit(int board_num) {
		return showoffDao.showoffBoardHit(board_num);
	}

	@Override
	public int memoryBoardRec(int memory_num) {
		return memoryDao.memoryBoardRec(memory_num);
	}

	@Override
	public int memoryBoardNrec(int memory_num) {
		return memoryDao.memoryBoardNrec(memory_num);
	}

	@Override
	public int showoffBoardRec(int board_num) {
		return showoffDao.showoffBoardRec(board_num);
	}

	@Override
	public int showoffBoardNrec(int board_num) {
		return showoffDao.showoffBoardNrec(board_num);
	}

	@Override
	public int memberJoin(MemberDTO memberDTO) {
		return memberDao.memberJoin(memberDTO);
	}

	@Override
	public int memberLogin(String user_id, String pw) {
		return memberDao.memberLogin(user_id, pw);
	}

	@Override
	public List<MemoryDTO> memoryRankingTopThree() {
		return null;
	}

	@Override
	public List<ShowoffDTO> showoffRankingTopThree() {
		return null;
	}

	public boolean isExistedId(String id) {
		return memberDao.isExistedId(id);
	}
	
	public MemberDTO memberInformation(String id) {
		return memberDao.memberInformation(id);
	}
	

	// contact 함수 
	   @Override
	   public int contactInsert(ContactDTO contactDTO) {
	      return contactDAO.contactInsert(contactDTO);
	   }

	   @Override
	   public List<ContactDTO> contactSelectAll(String contact_id) {
	      return contactDAO.contactSelectAll(contact_id);
	   }

	   @Override
	   public ContactDTO contactSelectOne(int contact_num) {
	      return contactDAO.contactSelectOne(contact_num);
	   }

	   @Override
	   public int contactUpdate(ContactDTO contactDTO) {
	      return contactDAO.contactUpdate(contactDTO);
	   }

	   @Override
	   public int contactDelete(int contact_num) {
	      return contactDAO.contactDelete(contact_num);
	   }
	      // 총 글 수 얻기 (추가)
	   @Override
	   public int getTotalContact(String contact_id) {
	      return contactDAO.getTotalContact(contact_id);
	   }
		// 카테고리별 전체글 불러오기
	   @Override
	   public List<MemoryDTO> membercategory(String memory_category) {
		return memoryDao.getcategoryMemory(memory_category);
	   }
}
