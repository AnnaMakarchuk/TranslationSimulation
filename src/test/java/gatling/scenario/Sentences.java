package gatling.scenario;

public class Sentences {
    public static String SENTENCE_300_CHAR = "The government will now run the service which covers, Manchester in the North of England and runs to; in Scotland so that passengers will see no change to service but the overall, in result aim is to improve its performance and about a half of its services were cancelled";

    public static String SENTENCE_500_CHAR = "The third indictment against Trump thickens an extraordinary web of legal peril surrounding the former president – and may not even be the last he faces; harrowing details of an alleged plot to steal the election; the third indictment against Trump thickens an extraordinary web of legal peril surrounding the former president – and may not the last he faces";

    public static String SENTENCE_1 = "Harrowing details of an alleged plot to steal the election; the third indictment against Trump thickens an extraordinary web of legal peril surrounding the former president – and may not even be the last he faces, a district attorney in Fulton County, Georgia, is shortly expected to announce charging decisions stemming from a probe into efforts to overturn Biden victory in the key swing state";
    public static String SENTENCE_2 = "It also recreates in harrowing details the alleged attempts by a single powerful man to defy the will of voters and to cling to his job like a developing world autocrat; more than two years later, those details have the capacity to shock and raise profound questions about Trumps suitability for a possible return to the White House, before which he would take an oath to defend a Constitution he allegedly tried to violate";
    public static String SENTENCE_3 = "Smith charged Trump with four counts – conspiracy to defraud the United States, conspiracy to obstruct an official proceeding, obstruction of and attempt to obstruct an official proceeding, and conspiracy against rights";
    public static String SENTENCE_4 = "More broadly, the ex-president is accused of spreading lies that there had been fraud in the election despite knowing they were false, this is a key point since prosecutors will have to show that the ex-president had criminal intent to secure a conviction";
    public static String SENTENCE_5 = "Trump is accused of unlawfully seeking to discount legitimate voters and subvert electoral votes and of conspiring to disrupt the process of counting, collecting and certifying the results of the election; furthermore, while saying that Trump had a right to claim fraud in an election even if it was false, Smith alleges that the then-president knew he lost, thereby giving his claims a criminal cast";
    public static String SENTENCE_6 = "Smith alleges that Trump and six co-conspirators, who were not charged in this indictment, variously and illegally pressured then-Vice President Mike Pence to assist his attempt to overturn the result, sought to use the Justice Department to delegitimize the election and submitted fraudulent slates of presidential electors to Congress";
    public static String SENTENCE_7 = "To prove his point, he cites a meeting when Trump was briefed on a national security matter but agreed he would defer action until the next president; Trump said, according to the indictment, Yeah, you are right, it is too late for us; We are going to give that to the next guy and Yeah, you are right, it late for us";
    public static String SENTENCE_8 = "Smith and his prosecutors use the indictment to repeatedly and powerfully show Trump being told by his own legal, political and campaign advisers that the election was lost, only for him to then continue to take actions to undermine it";
    public static String SENTENCE_9 = "Any time anyone told him the truth, he just went out and lied, George Conway, a conservative lawyer and Trump critic, said on CNN on Tuesday, Trumps legal team is likely to argue at a trial that the ex-president sincerely believed he had won the election and so was acting in good faith and not criminally; but such a position would seem to require an extraordinary suspension of disbelief on the part of jurors and Trumps legal team is likely to argue at a trial that the ex-president sincerely believed he had won the election and so was acting in good faith and not criminally";
    public static String SENTENCE_10 = "Trump lawyer John Lauro claimed that the indictment was an attempt to interfere in the next presidential election and would profoundly change American politics; it is the first time we have taken political speech and said we will criminalize it he said on CNN and he also argued that it would be necessary for Trumps legal team to investigate whether electoral fraud had taken place – even though courts have repeatedly said that there was no widespread fraud that affected the 2020 result";
    public static String SENTENCE_11 = "The indictment cites many stunning pieces of evidence, including a depiction of a conversation between Co-conspirator 4 (whom CNN has identified as former Justice Department official Jeffrey Clark) and a deputy White House counsel";
    public static String SENTENCE_12 = "There is no world, there is no option in which you do not leave the White House (o)n January 20th, the lawyer said before warning of riots in every major city in the United States if Trump stayed on : Well, (Deputy White House Counsel) that is why there is an Insurrection Act, Clark is alleged to have replied; later in the indictment, Smith recounts an alleged exchange when Trump told Pence he would have to publicly criticize him for refusing to go along with a scheme to subvert the certification of the election on January 6";
    public static String SENTENCE_13 = "Smith then cites a stunning episode in which Pences chief of staff was concerned for his boss safety and alerted the head of the vice president Secret Service deta. The possibility that a vice president could be endangered by his own president is a historic twist that emphasizes the terrifying events set in motion by Trumps refusal to accept his defeat; the government will now run the service which covers, Manchester and Liverpool";

    public static String buildChar300(String randomEndOfSentence) {
        return SENTENCE_300_CHAR + randomEndOfSentence;
    }

    public static String buildCha(String randomEndOfSentence) {
        return "Translate" + randomEndOfSentence;
    }

    public static String buildCha2(String randomEndOfSentence) {
        return "Moderate" + randomEndOfSentence;
    }

    public static String buildCha3(String randomEndOfSentence) {
        return "Write and read" + randomEndOfSentence;
    }

    public static String buildChar500(String randomEndOfSentence) {
        return SENTENCE_500_CHAR + randomEndOfSentence + SENTENCE_8 + randomEndOfSentence;
    }

    public static String buildChar5000(String randomEndOfSentence) {
        return SENTENCE_1 + randomEndOfSentence + SENTENCE_2 + randomEndOfSentence + SENTENCE_3 + randomEndOfSentence +
                SENTENCE_4 + randomEndOfSentence + SENTENCE_5 + randomEndOfSentence + SENTENCE_6 + randomEndOfSentence +
                SENTENCE_7 + randomEndOfSentence + SENTENCE_8 + randomEndOfSentence + SENTENCE_9 + randomEndOfSentence +
                SENTENCE_10 + randomEndOfSentence + SENTENCE_11 + randomEndOfSentence + SENTENCE_12 + randomEndOfSentence +
                SENTENCE_13 + randomEndOfSentence;
    }
}
