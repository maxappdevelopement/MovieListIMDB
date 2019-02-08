package appdevelopement.max.movielist250;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MovieListCreater {

   public List<String> createTitles() {

       List<String> top250List = new ArrayList<>();

        String html = "  Rank & Title\tIMDb Rating\tYour Rating\t\n" +
                " The Shawshank Redemption\t1. The Shawshank Redemption (1994)\t9,2\t\t\n" +
                " The Godfather\t2. The Godfather (1972)\t9,2\t\t\n" +
                " The Godfather: Part II\t3. The Godfather: Part II (1974)\t9,0\t\t\n" +
                " The Dark Knight\t4. The Dark Knight (2008)\t9,0\t\t\n" +
                " 12 Angry Men\t5. 12 Angry Men (1957)\t8,9\t\t\n" +
                " Schindler's List\t6. Schindler's List (1993)\t8,9\t\t\n" +
                " The Lord of the Rings: The Return of the King\t7. The Lord of the Rings: The Return of the King (2003)\t8,9\t\t\n" +
                " Pulp Fiction\t8. Pulp Fiction (1994)\t8,9\t\t\n" +
                " The Good, the Bad and the Ugly\t9. The Good, the Bad and the Ugly (1966)\t8,8\t\t\n" +
                " Fight Club\t10. Fight Club (1999)\t8,8\t\t\n" +
                " The Lord of the Rings: The Fellowship of the Ring\t11. The Lord of the Rings: The Fellowship of the Ring (2001)\t8,8\t\t\n" +
                " Forrest Gump\t12. Forrest Gump (1994)\t8,7\t\t\n" +
                " Star Wars: Episode V - The Empire Strikes Back\t13. Star Wars: Episode V - The Empire Strikes Back (1980)\t8,7\t\t\n" +
                " Inception\t14. Inception (2010)\t8,7\t\t\n" +
                " The Lord of the Rings: The Two Towers\t15. The Lord of the Rings: The Two Towers (2002)\t8,7\t\t\n" +
                " One Flew Over the Cuckoo's Nest\t16. One Flew Over the Cuckoo's Nest (1975)\t8,7\t\t\n" +
                " Goodfellas\t17. Goodfellas (1990)\t8,7\t\t\n" +
                " The Matrix\t18. The Matrix (1999)\t8,6\t\t\n" +
                " Seven Samurai\t19. Seven Samurai (1954)\t8,6\t\t\n" +
                " City of God\t20. City of God (2002)\t8,6\t\t\n" +
                " Se7en\t21. Se7en (1995)\t8,6\t\t\n" +
                " Star Wars: Episode IV - A New Hope\t22. Star Wars: Episode IV - A New Hope (1977)\t8,6\t\t\n" +
                " The Silence of the Lambs\t23. The Silence of the Lambs (1991)\t8,6\t\t\n" +
                " It's a Wonderful Life\t24. It's a Wonderful Life (1946)\t8,6\t\t\n" +
                " Life Is Beautiful\t25. Life Is Beautiful (1997)\t8,6\t\t\n" +
                " The Usual Suspects\t26. The Usual Suspects (1995)\t8,5\t\t\n" +
                " Spirited Away\t27. Spirited Away (2001)\t8,5\t\t\n" +
                " Saving Private Ryan\t28. Saving Private Ryan (1998)\t8,5\t\t\n" +
                " Léon: The Professional\t29. Léon: The Professional (1994)\t8,5\t\t\n" +
                " The Green Mile\t30. The Green Mile (1999)\t8,5\t\t\n" +
                " Interstellar\t31. Interstellar (2014)\t8,5\t\t\n" +
                " Psycho\t32. Psycho (1960)\t8,5\t\t\n" +
                " American History X\t33. American History X (1998)\t8,5\t\t\n" +
                " City Lights\t34. City Lights (1931)\t8,5\t\t\n" +
                " Once Upon a Time in the West\t35. Once Upon a Time in the West (1968)\t8,5\t\t\n" +
                " Casablanca\t36. Casablanca (1942)\t8,5\t\t\n" +
                " Spider-Man: Into the Spider-Verse\t37. Spider-Man: Into the Spider-Verse (2018)\t8,5\t\t\n" +
                " Modern Times\t38. Modern Times (1936)\t8,5\t\t\n" +
                " The Pianist\t39. The Pianist (2002)\t8,5\t\t\n" +
                " The Intouchables\t40. The Intouchables (2011)\t8,5\t\t\n" +
                " The Departed\t41. The Departed (2006)\t8,5\t\t\n" +
                " Terminator 2: Judgment Day\t42. Terminator 2: Judgment Day (1991)\t8,5\t\t\n" +
                " Back to the Future\t43. Back to the Future (1985)\t8,5\t\t\n" +
                " Whiplash\t44. Whiplash (2014)\t8,5\t\t\n" +
                " Rear Window\t45. Rear Window (1954)\t8,5\t\t\n" +
                " Raiders of the Lost Ark\t46. Raiders of the Lost Ark (1981)\t8,5\t\t\n" +
                " The Lion King\t47. The Lion King (1994)\t8,5\t\t\n" +
                " Gladiator\t48. Gladiator (2000)\t8,5\t\t\n" +
                " The Prestige\t49. The Prestige (2006)\t8,5\t\t\n" +
                " Apocalypse Now\t50. Apocalypse Now (1979)\t8,4\t\t\n" +
                " Memento\t51. Memento (2000)\t8,4\t\t\n" +
                " Alien\t52. Alien (1979)\t8,4\t\t\n" +
                " Avengers: Infinity War\t53. Avengers: Infinity War (2018)\t8,4\t\t\n" +
                " The Great Dictator\t54. The Great Dictator (1940)\t8,4\t\t\n" +
                " Cinema Paradiso\t55. Cinema Paradiso (1988)\t8,4\t\t\n" +
                " Grave of the Fireflies\t56. Grave of the Fireflies (1988)\t8,4\t\t\n" +
                " Sunset Boulevard\t57. Sunset Boulevard (1950)\t8,4\t\t\n" +
                " The Lives of Others\t58. The Lives of Others (2006)\t8,4\t\t\n" +
                " Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb\t59. Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb (1964)\t8,4\t\t\n" +
                " Paths of Glory\t60. Paths of Glory (1957)\t8,4\t\t\n" +
                " The Shining\t61. The Shining (1980)\t8,4\t\t\n" +
                " Django Unchained\t62. Django Unchained (2012)\t8,4\t\t\n" +
                " WALL·E\t63. WALL·E (2008)\t8,4\t\t\n" +
                " Princess Mononoke\t64. Princess Mononoke (1997)\t8,4\t\t\n" +
                " Witness for the Prosecution\t65. Witness for the Prosecution (1957)\t8,4\t\t\n" +
                " American Beauty\t66. American Beauty (1999)\t8,4\t\t\n" +
                " The Dark Knight Rises\t67. The Dark Knight Rises (2012)\t8,3\t\t\n" +
                " Old Boy - Revenge\t68. OldBoy (2003)\t8,3\t\t\n" +
                " Aliens\t69. Aliens (1986)\t8,3\t\t\n" +
                " Once Upon a Time in America\t70. Once Upon a Time in America (1984)\t8,3\t\t\n" +
                " Coco\t71. Coco (2017)\t8,3\t\t\n" +
                " Das Boot\t72. Das Boot (1981)\t8,3\t\t\n" +
                " Citizen Kane\t73. Citizen Kane (1941)\t8,3\t\t\n" +
                " Braveheart\t74. Braveheart (1995)\t8,3\t\t\n" +
                " Vertigo\t75. Vertigo (1958)\t8,3\t\t\n" +
                " North by Northwest\t76. North by Northwest (1959)\t8,3\t\t\n" +
                " Reservoir Dogs\t77. Reservoir Dogs (1992)\t8,3\t\t\n" +
                " Star Wars: Episode VI - Return of the Jedi\t78. Star Wars: Episode VI - Return of the Jedi (1983)\t8,3\t\t\n" +
                " M\t79. M (1931)\t8,3\t\t\n" +
                " Your Name.\t80. Your Name. (2016)\t8,3\t\t\n" +
                " Amadeus\t81. Amadeus (1984)\t8,3\t\t\n" +
                " Requiem for a Dream\t82. Requiem for a Dream (2000)\t8,3\t\t\n" +
                " Dangal\t83. Dangal (2016)\t8,3\t\t\n" +
                " Taare Zameen Par\t84. Taare Zameen Par (2007)\t8,3\t\t\n" +
                " Lawrence of Arabia\t85. Lawrence of Arabia (1962)\t8,3\t\t\n" +
                " Eternal Sunshine of the Spotless Mind\t86. Eternal Sunshine of the Spotless Mind (2004)\t8,3\t\t\n" +
                " A Clockwork Orange\t87. A Clockwork Orange (1971)\t8,3\t\t\n" +
                " 2001: A Space Odyssey\t88. 2001: A Space Odyssey (1968)\t8,3\t\t\n" +
                " 3 Idiots\t89. 3 Idiots (2009)\t8,3\t\t\n" +
                " Amélie\t90. Amélie (2001)\t8,3\t\t\n" +
                " Toy Story\t91. Toy Story (1995)\t8,3\t\t\n" +
                " Double Indemnity\t92. Double Indemnity (1944)\t8,3\t\t\n" +
                " Taxi Driver\t93. Taxi Driver (1976)\t8,3\t\t\n" +
                " Singin' in the Rain\t94. Singin' in the Rain (1952)\t8,3\t\t\n" +
                " Inglourious Basterds\t95. Inglourious Basterds (2009)\t8,3\t\t\n" +
                " Full Metal Jacket\t96. Full Metal Jacket (1987)\t8,3\t\t\n" +
                " To Kill a Mockingbird\t97. To Kill a Mockingbird (1962)\t8,3\t\t\n" +
                " Bicycle Thieves\t98. Bicycle Thieves (1948)\t8,3\t\t\n" +
                " The Kid\t99. The Kid (1921)\t8,3\t\t\n" +
                " The Sting\t100. The Sting (1973)\t8,3\t\t\n" +
                " Good Will Hunting\t101. Good Will Hunting (1997)\t8,3\t\t\n" +
                " Toy Story 3\t102. Toy Story 3 (2010)\t8,3\t\t\n" +
                " The Hunt\t103. The Hunt (2012)\t8,3\t\t\n" +
                " Snatch\t104. Snatch (2000)\t8,3\t\t\n" +
                " Scarface\t105. Scarface (1983)\t8,2\t\t\n" +
                " Monty Python and the Holy Grail\t106. Monty Python and the Holy Grail (1975)\t8,2\t\t\n" +
                " For a Few Dollars More\t107. For a Few Dollars More (1965)\t8,2\t\t\n" +
                " L.A. Confidential\t108. L.A. Confidential (1997)\t8,2\t\t\n" +
                " The Apartment\t109. The Apartment (1960)\t8,2\t\t\n" +
                " Metropolis\t110. Metropolis (1927)\t8,2\t\t\n" +
                " A Separation\t111. A Separation (2011)\t8,2\t\t\n" +
                " Indiana Jones and the Last Crusade\t112. Indiana Jones and the Last Crusade (1989)\t8,2\t\t\n" +
                " Rashomon\t113. Rashomon (1950)\t8,2\t\t\n" +
                " Up\t114. Up (2009)\t8,2\t\t\n" +
                " All About Eve\t115. All About Eve (1950)\t8,2\t\t\n" +
                " Batman Begins\t116. Batman Begins (2005)\t8,2\t\t\n" +
                " Yojimbo\t117. Yojimbo (1961)\t8,2\t\t\n" +
                " Some Like It Hot\t118. Some Like It Hot (1959)\t8,2\t\t\n" +
                " Unforgiven\t119. Unforgiven (1992)\t8,2\t\t\n" +
                " Downfall\t120. Downfall (2004)\t8,2\t\t\n" +
                " Die Hard\t121. Die Hard (1988)\t8,2\t\t\n" +
                " The Treasure of the Sierra Madre\t122. The Treasure of the Sierra Madre (1948)\t8,2\t\t\n" +
                " Heat\t123. Heat (1995)\t8,2\t\t\n" +
                " Ikiru\t124. Ikiru (1952)\t8,2\t\t\n" +
                " Incendies\t125. Incendies (2010)\t8,2\t\t\n" +
                " Raging Bull\t126. Raging Bull (1980)\t8,2\t\t\n" +
                " The Great Escape\t127. The Great Escape (1963)\t8,2\t\t\n" +
                " Children of Heaven\t128. Children of Heaven (1997)\t8,2\t\t\n" +
                " Pan's Labyrinth\t129. Pan's Labyrinth (2006)\t8,2\t\t\n" +
                " My Father and My Son\t130. My Father and My Son (2005)\t8,2\t\t\n" +
                " Bohemian Rhapsody\t131. Bohemian Rhapsody (2018)\t8,2\t\t\n" +
                " Chinatown\t132. Chinatown (1974)\t8,2\t\t\n" +
                " The Third Man\t133. The Third Man (1949)\t8,2\t\t\n" +
                " My Neighbor Totoro\t134. My Neighbor Totoro (1988)\t8,2\t\t\n" +
                " Howl's Moving Castle\t135. Howl's Moving Castle (2004)\t8,2\t\t\n" +
                " Ran\t136. Ran (1985)\t8,2\t\t\n" +
                " Judgment at Nuremberg\t137. Judgment at Nuremberg (1961)\t8,2\t\t\n" +
                " The Secret in Their Eyes\t138. The Secret in Their Eyes (2009)\t8,2\t\t\n" +
                " The Gold Rush\t139. The Gold Rush (1925)\t8,2\t\t\n" +
                " The Bridge on the River Kwai\t140. The Bridge on the River Kwai (1957)\t8,2\t\t\n" +
                " A Beautiful Mind\t141. A Beautiful Mind (2001)\t8,2\t\t\n" +
                " Lock, Stock and Two Smoking Barrels\t142. Lock, Stock and Two Smoking Barrels (1998)\t8,2\t\t\n" +
                " Three Billboards Outside Ebbing, Missouri\t143. Three Billboards Outside Ebbing, Missouri (2017)\t8,2\t\t\n" +
                " Casino\t144. Casino (1995)\t8,2\t\t\n" +
                " On the Waterfront\t145. On the Waterfront (1954)\t8,2\t\t\n" +
                " The Seventh Seal\t146. The Seventh Seal (1957)\t8,2\t\t\n" +
                " Inside Out\t147. Inside Out (2015)\t8,1\t\t\n" +
                " The Elephant Man\t148. The Elephant Man (1980)\t8,1\t\t\n" +
                " Room\t149. Room (2015)\t8,1\t\t\n" +
                " The Wolf of Wall Street\t150. The Wolf of Wall Street (2013)\t8,1\t\t\n" +
                " Mr. Smith Goes to Washington\t151. Mr. Smith Goes to Washington (1939)\t8,1\t\t\n" +
                " V for Vendetta\t152. V for Vendetta (2005)\t8,1\t\t\n" +
                " Warrior\t153. Warrior (2011)\t8,1\t\t\n" +
                " Blade Runner\t154. Blade Runner (1982)\t8,1\t\t\n" +
                " Dial M for Murder\t155. Dial M for Murder (1954)\t8,1\t\t\n" +
                " Wild Strawberries\t156. Wild Strawberries (1957)\t8,1\t\t\n" +
                " The General\t157. The General (1926)\t8,1\t\t\n" +
                " No Country for Old Men\t158. No Country for Old Men (2007)\t8,1\t\t\n" +
                " Trainspotting\t159. Trainspotting (1996)\t8,1\t\t\n" +
                " There Will Be Blood\t160. There Will Be Blood (2007)\t8,1\t\t\n" +
                " The Sixth Sense\t161. The Sixth Sense (1999)\t8,1\t\t\n" +
                " Gone with the Wind\t162. Gone with the Wind (1939)\t8,1\t\t\n" +
                " The Thing\t163. The Thing (1982)\t8,1\t\t\n" +
                " Fargo\t164. Fargo (1996)\t8,1\t\t\n" +
                " Gran Torino\t165. Gran Torino (2008)\t8,1\t\t\n" +
                " The Deer Hunter\t166. The Deer Hunter (1978)\t8,1\t\t\n" +
                " Finding Nemo\t167. Finding Nemo (2003)\t8,1\t\t\n" +
                " Come and See\t168. Come and See (1985)\t8,1\t\t\n" +
                " The Big Lebowski\t169. The Big Lebowski (1998)\t8,1\t\t\n" +
                " Sherlock Jr.\t170. Sherlock Jr. (1924)\t8,1\t\t\n" +
                " Shutter Island\t171. Shutter Island (2010)\t8,1\t\t\n" +
                " Kill Bill: Vol. 1\t172. Kill Bill: Vol. 1 (2003)\t8,1\t\t\n" +
                " Cool Hand Luke\t173. Cool Hand Luke (1967)\t8,1\t\t\n" +
                " Rebecca\t174. Rebecca (1940)\t8,1\t\t\n" +
                " Tokyo Story\t175. Tokyo Story (1953)\t8,1\t\t\n" +
                " Mary & Max\t176. Mary & Max (2009)\t8,1\t\t\n" +
                " Hacksaw Ridge\t177. Hacksaw Ridge (2016)\t8,1\t\t\n" +
                " Gone Girl\t178. Gone Girl (2014)\t8,1\t\t\n" +
                " How to Train Your Dragon\t179. How to Train Your Dragon (2010)\t8,1\t\t\n" +
                " Sunrise\t180. Sunrise (1927)\t8,1\t\t\n" +
                " Wild Tales\t181. Wild Tales (2014)\t8,1\t\t\n" +
                " Jurassic Park\t182. Jurassic Park (1993)\t8,1\t\t\n" +
                " Into the Wild\t183. Into the Wild (2007)\t8,1\t\t\n" +
                " Life of Brian\t184. Life of Brian (1979)\t8,1\t\t\n" +
                " In the Name of the Father\t185. In the Name of the Father (1993)\t8,1\t\t\n" +
                " Platoon\t186. Platoon (1986)\t8,1\t\t\n" +
                " The Grand Budapest Hotel\t187. The Grand Budapest Hotel (2014)\t8,1\t\t\n" +
                " The Truman Show\t188. The Truman Show (1998)\t8,1\t\t\n" +
                " It Happened One Night\t189. It Happened One Night (1934)\t8,1\t\t\n" +
                " Stand by Me\t190. Stand by Me (1986)\t8,1\t\t\n" +
                " The Bandit\t191. The Bandit (1996)\t8,1\t\t\n" +
                " Network\t192. Network (1976)\t8,1\t\t\n" +
                " Stalker\t193. Stalker (1979)\t8,1\t\t\n" +
                " Persona\t194. Persona (1966)\t8,1\t\t\n" +
                " Hotel Rwanda\t195. Hotel Rwanda (2004)\t8,1\t\t\n" +
                " Ben-Hur\t196. Ben-Hur (1959)\t8,1\t\t\n" +
                " Memories of Murder\t197. Memories of Murder (2003)\t8,1\t\t\n" +
                " 12 Years a Slave\t198. 12 Years a Slave (2013)\t8,1\t\t\n" +
                " Million Dollar Baby\t199. Million Dollar Baby (2004)\t8,1\t\t\n" +
                " The Passion of Joan of Arc\t200. The Passion of Joan of Arc (1928)\t8,1\t\t\n" +
                " Andrei Rublev\t201. Andrei Rublev (1966)\t8,1\t\t\n" +
                " The Wages of Fear\t202. The Wages of Fear (1953)\t8,1\t\t\n" +
                " Rush\t203. Rush (2013)\t8,1\t\t\n" +
                " Before Sunrise\t204. Before Sunrise (1995)\t8,1\t\t\n" +
                " Mad Max: Fury Road\t205. Mad Max: Fury Road (2015)\t8,1\t\t\n" +
                " The 400 Blows\t206. The 400 Blows (1959)\t8,1\t\t\n" +
                " Spotlight\t207. Spotlight (2015)\t8,1\t\t\n" +
                " Prisoners\t208. Prisoners (2013)\t8,1\t\t\n" +
                " Hachi: A Dog's Tale\t209. Hachi: A Dog's Tale (2009)\t8,1\t\t\n" +
                " Rang De Basanti\t210. Rang De Basanti (2006)\t8,1\t\t\n" +
                " Logan\t211. Logan (2017)\t8,1\t\t\n" +
                " Amores Perros\t212. Amores Perros (2000)\t8,1\t\t\n" +
                " The Princess Bride\t213. The Princess Bride (1987)\t8,1\t\t\n" +
                " Catch Me If You Can\t214. Catch Me If You Can (2002)\t8,0\t\t\n" +
                " Nausicaä of the Valley of the Wind\t215. Nausicaä of the Valley of the Wind (1984)\t8,0\t\t\n" +
                " Harry Potter and the Deathly Hallows: Part 2\t216. Harry Potter and the Deathly Hallows: Part 2 (2011)\t8,0\t\t\n" +
                " Butch Cassidy and the Sundance Kid\t217. Butch Cassidy and the Sundance Kid (1969)\t8,0\t\t\n" +
                " Rocky\t218. Rocky (1976)\t8,0\t\t\n" +
                " Barry Lyndon\t219. Barry Lyndon (1975)\t8,0\t\t\n" +
                " Monsters, Inc.\t220. Monsters, Inc. (2001)\t8,0\t\t\n" +
                " The Grapes of Wrath\t221. The Grapes of Wrath (1940)\t8,0\t\t\n" +
                " The Maltese Falcon\t222. The Maltese Falcon (1941)\t8,0\t\t\n" +
                " Dead Poets Society\t223. Dead Poets Society (1989)\t8,0\t\t\n" +
                " Donnie Darko\t224. Donnie Darko (2001)\t8,0\t\t\n" +
                " The Terminator\t225. The Terminator (1984)\t8,0\t\t\n" +
                " Gandhi\t226. Gandhi (1982)\t8,0\t\t\n" +
                " Diabolique\t227. Diabolique (1955)\t8,0\t\t\n" +
                " La Haine\t228. La Haine (1995)\t8,0\t\t\n" +
                " Groundhog Day\t229. Groundhog Day (1993)\t8,0\t\t\n" +
                " The Wizard of Oz\t230. The Wizard of Oz (1939)\t8,0\t\t\n" +
                " Jaws\t231. Jaws (1975)\t8,0\t\t\n" +
                " The Nights of Cabiria\t232. The Nights of Cabiria (1957)\t8,0\t\t\n" +
                " The Help\t233. The Help (2011)\t8,0\t\t\n" +
                " In the Mood for Love\t234. In the Mood for Love (2000)\t8,0\t\t\n" +
                " Tangerines\t235. Tangerines (2013)\t8,0\t\t\n" +
                " Before Sunset\t236. Before Sunset (2004)\t8,0\t\t\n" +
                " Paper Moon\t237. Paper Moon (1973)\t8,0\t\t\n" +
                " Paris, Texas\t238. Paris, Texas (1984)\t8,0\t\t\n" +
                " Blade Runner 2049\t239. Blade Runner 2049 (2017)\t8,0\t\t\n" +
                " The Handmaiden\t240. The Handmaiden (2016)\t8,0\t\t\n" +
                " La La Land\t241. La La Land (2016)\t8,0\t\t\n" +
                " Sanjuro\t242. Sanjuro (1962)\t8,0\t\t\n" +
                " Castle in the Sky\t243. Castle in the Sky (1986)\t8,0\t\t\n" +
                " The Best Years of Our Lives\t244. The Best Years of Our Lives (1946)\t8,0\t\t\n" +
                " Pirates of the Caribbean: The Curse of the Black Pearl\t245. Pirates of the Caribbean: The Curse of the Black Pearl (2003)\t8,0\t\t\n" +
                " Guardians of the Galaxy\t246. Guardians of the Galaxy (2014)\t8,0\t\t\n" +
                " Drishyam\t247. Drishyam (2015)\t8,0\t\t\n" +
                " Swades\t248. Swades (2004)\t8,0\t\t\n" +
                " 8½\t249. 8½ (1963)\t8,0\t\t\n" +
                " Lagaan\t250. Lagaan (2001)\t8,0   ";

        for (int i = 0; i < 249; i++) {

            Pattern p = Pattern.compile("\t" + i + ". (.*?) \\(");
            Matcher m = p.matcher(html);

            while (m.find()) {
                top250List.add(m.group(1));
            }
        }
        return top250List;
    }
}

