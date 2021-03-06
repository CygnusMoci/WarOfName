package com.moci.defaultandroid;

import com.moci.warofname.entity.NameHero;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void init(){
        String name = "CygnusMoci$%^&*()_!@#!@#!";
        int len = name.length();
        char[] temp = new char[len];
        int[] t = new int[len];
        for (int i = 0; i <len ; i++) {
            temp[i] = name.charAt(i);
            t[i] = name.charAt(i);
        }

        for (int i = 0; i < len; i++) {
            System.out.println(temp[i]+" "+t[i]);
        }
        System.out.println(sign(t));
    }
    private String sign(int[] arr){
        int len = arr.length;
        StringBuffer strSign = new StringBuffer();
        for (int i = 0; i < len; i++) {
            strSign.append(arr[i]);
        }
        return strSign.toString();
    }

    @Test
    public void nameHero(){
        String str = "字表的制定，坚持了汉字简化的基本方针，同时也遵循了国务院1986年批转国家语委《关于废止〈第二次汉字简化方案（草案）〉和纠正社会用字混乱现象的请示的通知》中所指出的“今后，对汉字的简化应持谨慎态度，使汉字的形体在一个时期内保持相对稳定”的原则。《第一批异体字整理表》、《简化字总表》、《印刷通用汉字字形表》、《现代汉语常用字表》、《现代汉语通用字表》等已有的汉字规范，经过数十年实践的考验，很多精神和大量成果值得承袭和吸取。字表继承了这些规范的原则和主要内容，对其中错误、疏漏、相互矛盾及不能满足当今社会需要之处，则在详细调查和认真分析的基础上，充分考虑到历史形成的全民习惯和社会的可接受程度，遵照便民利国的原则，进行必要的修订。\n" +
                "（二）坚持实事求是的科学精神，遵循汉字构造和演变的规律。\n" +
                "字表制定过程中，邀请了中国多位资深的语言文字学家主持和参与工作，又反复听取了很多其他语言文字学家和相关领域专业人员的意见，注意吸收汉字学与汉字史研究的最新成果，采用科学的统计方法获取可靠的数据；同时也广泛吸取基础教育、古籍整理、辞书编纂、印刷出版、计算机信息处理等部门的实践经验，遵循汉字构造和演变的规律,充分考虑汉字应用的实际，尽可能提高汉字规范的科学性与可行性。\n" +
                "（三）广泛听取各界意见，照顾不同领域汉字应用的需要。\n" +
                "字表的制定，坚持了群众路线，通过各种方式听取广大人民群众的意见，尤其是基础教育和文化普及领域所反映的意见，尽量满足不同领域、不同文化程度的人群对汉字使用的不同要求。\n" +
                "（四）适当考虑汉字在台湾、香港、澳门的使用情况和国际化的需求。\n" +
                "汉字通行于两岸四地，而且还跨越国界，传播到世界各地。字表的制定，正视使用汉字的不同国家、地区简繁字形并存并用的客观实际，兼顾汉字使用的现状及国际化的各种需求，尽量避免扩大不同国家或地区之间汉字使用的差异，以利于相互之间的沟通和交流。\n" +
                "解决问题\n" +
                "第一，关于汉字简繁问题。字表研制过程中，对繁体字恢复和类推简化问题，曾进行过反复的研讨。研制组最终得出的结论是：为了维护社会用字的稳定，字表原则上不恢复繁体字；将类推简化的范围严格限定在字表以内，以保持通用层面用字的系统性和稳定性；允许字表以外的字有条件使用，但不类推简化。\n" +
                "第二，关于异体字问题。为尊重社会习惯，方便人们用字需要，字表将《第一批异体字整理表》中的51个异体字收入表中，主要用作人名地名，如“喆”“淼”“堃”“升”等。对异体字不再简单地提“淘汰、废除”，但在使用上有明确要求。\n" +
                "第三，关于字形问题。字表对宋体字形进行了规范，依据《印刷通用汉字字形表》总结和制定了字形规则，对一些不符合字形规则的字的字形作了微调。字形调整的原则是：尊重汉字结构，遵循统一规则，严格控制特例。字形调整的原则和字形规则，不仅使表内字的字形保持了系统性，也使今后大批量汉字的字形整理有章可循，避免出现新的字形不统一现象。\n" +
                "第四，关于字表的属性。字表的研制，是以大量的统计数据为基础，以满足现代语言生活的用字需要为目的，具有通用性、现代性和规范性。规范性是字表的本质属性。\n" +
                "第五，关于字表的效力。字表的研制，充分考虑了社会各领域的用字需要。字表发布后，社会各领域的现代通用汉字，应使用表内字。个别情况下需要使用表外字的，仍可以使用，但要选用历史上确曾通用过的字形，不要任意类推简化、造字或改字。为确保字表的有效性，今后字表会根据语言生活的变化，适时进行修订。\n" +
                "具体调整编辑\n" +
                "异体处理\n" +
                "严格异体字的定义应当是：音义全同、记词职能完全一样、仅仅字形不同，它们在任何语境下都能互相替代而不影响表达的意义的一组字。可以看出，从功能来看，异体字是汉字的冗余，徒增记忆的负担，需要加以规范。1955年12月22日发布的《第一批异体字整理表》的说明中指出：“从实施日起，全国出版的报纸、杂志、图书一律停止使用表中括号内的异体字。但翻印古书须用原文原字的，可作例外。”这个说明明确了异体字属于“不规范的字”的范围，异体字在通用层面上书写现代汉语文本时，不能使用。但是，在该异体字整理表中确定的“异体字”，有些并不是严格意义上的异体字。把这些字都列入“不规范的字”的范围而取消，有时不利于意义的精确表达。\n" +
                "《通用规范汉字表》对《第一批异体字整理表》进行整理时，采用了科学的原则、稳定的原则和求实的原则，形音义并重，对各组字的关系进行了重新认定，并规定今后对这类字，不再采用简单的“取消”“废除”而要采取“认同”和“辨析”的处理方法。\n" +
                "《第一批异体字整理表》在1955年12月发布后，有些相关的文件曾对其进行过改动，主要是：（1）1956年3月发布的《修正〈第一批异体字整理表〉内“阪”“挫”二字的通知》；（2）《简化字总表》（1986年10月10日重新发表）和《关于发布〈现代汉语通用字表〉的联合通知》（1988年3月25日发布）中重新认定了26个字；（3）1993年《关于“镕”字使用问题的批复》。上述3个文件总共恢复了29字，分别是：阪、挫、䜣、䜩、晔、詟、诃、䲡、䌷、刬、鲙、诓、雠、翦、邱、於、澹、骼、彷、菰、溷、徼、薰、黏、桉、愣、晖、凋、镕。此次制定《新订异体字整理表》时，根据现有原则对这29个字重新审核，审核后的处理结果为：“ 䜩、䲡、䌷、刬”4字仍按异体字处理，其余25字收入《通用规范汉字表》。此外，根据群众的意见，《通用规范汉字表》还将51个异体字恢复为规范字，并在各级字表中相应的字下增加注释，说明这些字恢复为规范字后的使用范围：\n" +
                "恢复到二级字表中共6字，其中只恢复其部分音项的1字，即“袷”；完全恢复不再作为异体字的5字，分别是“噘、栗、蹚、皙、瞋”。\n" +
                "恢复到三级字表中共45字，其中只恢复其部分音项的5字，分别是氾、勑、叚、絜、釐；恢复其部分义项的36字，分别是仝、邨、扞、吒、飏、昇、并、迳、迺、钜、祕、陞、勣、桠、赀、（钅卢=鑪）、脩、砦、堃、喆、蒐、椀、甦、淼、犇、肴、頫、甯、缐、劄、賸、麹、谿、瓌、驩、龢；完全恢复不再作为异体字的4字，分别是凓、勠、菉、曏。\n" +
                "类推简化\n" +
                "《通用规范汉字表》对类推简化采用了尊重现实和严格限制的原则。所谓尊重现实，是对在《现代汉语通用字表》范围内已经有限类推的字仍然保留。由于姓氏人名、科技用字和用简化字印刷的语文课本中的文言文用字多数也已经类推，因此，三级字表也采用有限类推的办法，实行类推简化，与一、二级字表保持一致。其具体细则是：（1）按《简化字总表》第二表规定的132字与14个偏旁的范围类推，不扩大范围。（2）尽量只在第一层次构字时类推，以保持原字的结构不受影响。（3）采用以上原则产生难以识别的怪异字或产生同形字时，为保持字与字的区别，作个别变通处理。不予类推简化。\n" +
                "《通用规范汉字表》以外的字，根据国务院1986年“今后，对汉字的简化应持谨慎态度，使汉字的形体在一个时期内保持相对稳定”的指示精神，不再类推简化；个别领域确需类推简化的，需报国家语言文字工作主管部门批准。\n" +
                "公众反应编辑\n" +
                "《通用规范汉字表（征求意见稿）》发布之后引起了较大的反应，据《字表》公开征求意见工作领导小组2009年9月2日公告，从8月12日到8月31日的二十天公开征求意见期间中，《字表》意见收集组共收到社会各界人士发来的电子邮件2688件、信函157件、传真67件，总计2912件。另外还有许多人士通过报纸、广播、电视、网络等媒体提出了大量的意见和建议。从公开征求意见情况来看，一是对字表公开征求意见的方式予以充分肯定；二是肯定字表的意义和作用；三是从不同角度提出了许多针对性强、富有建设性的主要集中在字形、补充用字和异体字三个方面的问题的意见和建议：\n" +
                "1．关于字形问题，44个汉字字形微调引起了社会广泛关注。大多数意见认为字形微调会改变长期以来形成的使用习惯，将给大众用字造成麻烦，担心影响学生学习、考试和增加社会成本，认为不宜轻易改动。\n" +
                "2．关于补充用字问题，要求补充用字的意见和建议占有很大比例，要求补充的字主要是姓氏、人名、地名、科技术语等方面的用字，大都是在语料库和许多渠道中难以收集到的社会用字。比如“外‘门’内‘合’、上‘亠’下‘思’、上‘比’下‘干’”等字。\n" +
                "3．关于异体字问题，多数意见赞成字表恢复51个异体字，认为这符合社会用字实际需要，比如“喆、淼、仝”等字。\n" +
                "另据报道，教育部语言文字应用研究所所长姚喜双在接受采访时透露：“据我们统计的数字，绝大多数公众是反对44个汉字微调的，这和网上的调查数据吻合。”对于此前有媒体所报道的教育部称67%的公众支持汉字微调与网上的八九成的不支持形成了鲜明的反差所引发了网友的质疑，姚喜双指出：“说67%的公众支持44个字的微调，是误传误报。据我们统计的数字，绝大多数公众是反对44个汉字微调的。这和网上的调查数据吻合。我们会把这个数据反映给专家组，请大家放心。”\n" +
                "虽然公众主要是对44个汉字字形微调的反对意见比较强烈，但大多是即兴式的情绪型呼吁，这在网络和报纸中是很明显的，而极少从理性上进行的认真研究讨论。";
//        for (int i = 0; i < str.length()-3; i++) {
//            String name = str.charAt(i)+""+str.charAt(i+1)+str.charAt(i+2)+str.charAt(i+3);
//            NameHero pT = new NameHero(name);
//            System.out.println(pT);
//        }
        while (true){
            String a = System.currentTimeMillis()+"";
            try {
                Thread.sleep(500);
                NameHero pT = new NameHero(a);
                System.out.println(a+pT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}